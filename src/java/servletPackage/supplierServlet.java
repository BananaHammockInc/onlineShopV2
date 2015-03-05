/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import cartPackage.ShoppingCartItem;
import customObject.getTodayDate;
import customObject.orderController;
import customObject.userSession;
import entityPackage.InvoiceContentTable;
import entityPackage.InvoiceTable;
import entityPackage.ProductTable;
import facadePackage.ProductTableFacade;
import entityPackage.SupplierTable;
import facadePackage.InvoiceContentTableFacade;
import facadePackage.InvoiceTableFacade;
import facadePackage.SupplierTableFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 
 * Aaron Kelly - 12350566
 * Alex McElhinney - 12437802
 * Evan Preisler - 10101753
 * CT338 - Software Engineering Project: Banana Hammock, Online Fruit & Veg Store
 * 2015
 * 
 *
 * @author dex
 */
@WebServlet(name = "productSupplierServlet", urlPatterns = {"/newProductServlet",
    "/supplierServlet", "/addNewProduct", "/newSupplierServlet", "/viewOrder",
    "/createOrder", "/getContent", "/updateOrder", "/checkOrder", "/confirmOrder"})
public class supplierServlet extends HttpServlet {

    @EJB
    private SupplierTableFacade SupTable;
    @EJB
    private ProductTableFacade ProTable;
    @EJB
    private InvoiceTableFacade invFacade;
    @EJB
    private InvoiceContentTableFacade conFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userSession user = (userSession) request.getSession().getAttribute("user");
        if (request.getServletPath().equals("/newProductServlet")) {
            SupplierTable getSup = SupTable.find(Integer.parseInt(request.getParameter("supplierName")));
            ProductTable newProduct = new ProductTable();
            newProduct.setProductName(request.getParameter("productName"));
            newProduct.setDescription(request.getParameter("description"));
            newProduct.setWholesalePrice(Double.parseDouble(request.getParameter("wholesalePrice")));
            newProduct.setRetailPrice(Double.parseDouble(request.getParameter("retailPrice")));
            newProduct.setStockLevel(Integer.parseInt(request.getParameter("stockLevel")));
            if(newProduct.getStockLevel() < 0) newProduct.setStockLevel(0);
            newProduct.setSupplierID(getSup);
            ProTable.create(newProduct);
            request.getRequestDispatcher("productServlet").forward(request, response);
        } else if (request.getServletPath().equals("/newSupplierServlet")) {
            SupplierTable sup = new SupplierTable();
            sup.setBusinessName(request.getParameter("BusinessName"));
            sup.setPassword(request.getParameter("UserPassword"));
            SupTable.create(sup);
            request.getRequestDispatcher("loginOk.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/viewOrder")) {
            System.out.println("check");
            orderController oc = new orderController();
            List<InvoiceTable> invoice = invFacade.findAll();
            if(user.getSupplierAdmin()) {
                for(InvoiceTable i : invoice) {
                    if(user.getSupplier().getSID().equals(i.getInID())) {
                        oc.addInvoice(i);
                    }
                }
            } else if(user.getAdmin()) {
                oc.setInvoice(invoice);
            }
            request.setAttribute("allOrder", oc);
            request.getRequestDispatcher("showAllOrders.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/getContent")) {
            int invoiceNumber = Integer.parseInt(request.getParameter("invoiceID"));
            System.out.println(invoiceNumber);
            orderController oc = new orderController();
            List<InvoiceContentTable> content = conFacade.findAll();
            for(InvoiceContentTable i : content) {
                if(i.getInvoiceID().getInID().equals(invoiceNumber)) {
                    oc.addContent(i);
                }
            }
            for(InvoiceContentTable c : oc.getContent()) {
                System.out.println(c.getInvoiceID().getInID());
            }
            request.setAttribute("allOrder", oc);
            request.getRequestDispatcher("showContentResult.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/createOrder")) {
            List<ProductTable> products = ProTable.findAll();
            int userID = user.getSupplier().getSID();
            List<ProductTable> supplierProduct = new ArrayList<ProductTable>();
            for(ProductTable p : products) {
                if(p.getSupplierID().getSID().equals(userID)) {
                    supplierProduct.add(p);
                }
            }
            request.setAttribute("product", supplierProduct);
            request.getRequestDispatcher("createOrder.jsp").forward(request, response);
        } else if(request.getServletPath().equals("/updateOrder")) {
            int productID = Integer.parseInt(request.getParameter("productID"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            ProductTable product = ProTable.find(productID);
            if(quantity >= 0 ) {
                user.getCart().addItem(product);
                user.getCart().update(product, (short) quantity);
            }
            List<ProductTable> products = ProTable.findAll();
            int userID = user.getSupplier().getSID();
            List<ProductTable> supplierProduct = new ArrayList<ProductTable>();
            
            for(ProductTable p : products) {
                if(p.getSupplierID().getSID().equals(userID)) {
                    supplierProduct.add(p);
                }
            }
            for(ShoppingCartItem s : user.getCart().getItems()) {
                System.out.println(s.getProduct().getProductName());
            }
            request.setAttribute("product", supplierProduct);
            request.getRequestDispatcher("createOrder.jsp").forward(request, response);
        } else if(request.getServletPath().equals("/checkOrder")) {
            request.getRequestDispatcher("reviewOrder.jsp").forward(request, response);
        } else if(request.getServletPath().equals("/confirmOrder")) {
            int totalAdded = 0;
            List<InvoiceContentTable> contentTable = new ArrayList<InvoiceContentTable>();
            InvoiceContentTable content = new InvoiceContentTable();
            for(ShoppingCartItem sci : user.getCart().getItems()) {
                int quantity = sci.getQuantity();
                totalAdded += quantity;
                ProductTable p = ProTable.find(sci.getProduct().getPID());
                int currentQ = p.getStockLevel();
                p.setStockLevel(quantity + currentQ);
                ProTable.edit(p);
                content.setProductID(p);
                content.setAmountAdded(quantity);
                contentTable.add(content);
            }
            getTodayDate today = new getTodayDate();
            InvoiceTable invoice = new InvoiceTable();
            invoice.setDate(today.getDate());
            invoice.setSupplierID(user.getSupplier());
            invoice.setTotalAdded(totalAdded);
            invFacade.create(invoice);
            for(InvoiceContentTable i : contentTable) {
                i.setInvoiceID(invoice);
                conFacade.create(i);
            }
            request.getRequestDispatcher("supplierLogin.jsp").forward(request, response);
        } else {
            List<SupplierTable> suppliers = new ArrayList<SupplierTable>();
            if(!user.getSupplierAdmin()) {
                suppliers = SupTable.findAll();
            } else {
                suppliers.add(user.getSupplier());
            }
            request.setAttribute("supplierList", suppliers);
            if (request.getServletPath().equals("/supplierServlet")) {
                request.getRequestDispatcher("showSupplier.jsp").forward(request, response);
            } else if (request.getServletPath().equals("/addNewProduct")) {
                request.getRequestDispatcher("createProduct.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
