/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import customObject.getTodayDate;
import cartPackage.ShoppingCartItem;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entityPackage.ProductTable;
import entityPackage.PurchaseTable;
import customObject.userSession;
import entityPackage.EmployeePurchaseTable;
import entityPackage.EmployeeReceiptTable;
import entityPackage.ReceiptTable;
import facadePackage.EmployeePurchaseTableFacade;
import facadePackage.EmployeeReceiptTableFacade;
import facadePackage.ProductTableFacade;
import facadePackage.PurchaseTableFacade;
import facadePackage.ReceiptTableFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
@WebServlet(name = "cartServlet", urlPatterns = {"/addToCart", "/updateCart", "/CheckOut"})
public class cartServlet extends HttpServlet {

    @EJB
    private ProductTableFacade proFacade;
    @EJB
    private PurchaseTableFacade purFacade;
    @EJB
    private ReceiptTableFacade recFacade;
    @EJB
    private EmployeePurchaseTableFacade empPurFacade;
    @EJB
    private EmployeeReceiptTableFacade empRecFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        userSession user = (userSession) session.getAttribute("user");
        if (request.getServletPath().equals("/addToCart")) {
            if (user == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            List<ProductTable> products = proFacade.findAll();
            int productId = Integer.parseInt(request.getParameter("productId"));
            if (productId >= 0) {
                ProductTable product = proFacade.find(productId);
                user.getCart().addItem(product);
                System.out.println("product added:" + product.getProductName());
            }
            request.setAttribute("productList", products);
            try {
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (request.getServletPath().equals("/updateCart")) {
            System.out.println("updating:");
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            ProductTable product = proFacade.find(productId);
            if (quantity < 1) {
                user.getCart().removeItem(product);
            }
            user.getCart().update(product, (short) quantity);
            System.out.println("product updated:" + product.getProductName());
            try {
                request.getRequestDispatcher("viewCart").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (request.getServletPath().equals("/CheckOut")) {
            System.out.println("Checking out:");
            int totalRemoved = 0;
            List<ReceiptTable> receiptTable = new ArrayList<ReceiptTable>();
            List<EmployeeReceiptTable> employeeReceiptTable = new ArrayList<EmployeeReceiptTable>();
            if (user.getAdmin()) {
                for (ShoppingCartItem sci : user.getCart().getItems()) {
                    EmployeeReceiptTable newEmpReceipt = new EmployeeReceiptTable();
                    System.out.println(sci.getProduct().getProductName());
                    int quantity = sci.getQuantity();
                    totalRemoved += sci.getQuantity();
                    ProductTable p = proFacade.find(sci.getProduct().getPID());
                    int currentQ = p.getStockLevel();
                    p.setStockLevel(currentQ - quantity);
                    proFacade.edit(p);
                    newEmpReceipt.setAmountRemoved(quantity);
                    newEmpReceipt.setCost(p.getRetailPrice() * quantity);
                    newEmpReceipt.setProductID(p);
                    employeeReceiptTable.add(newEmpReceipt);
                }
                for (EmployeeReceiptTable r : employeeReceiptTable) {
                    System.out.println(r.getProductID().getProductName() + ", " + r.getAmountRemoved());
                }
                getTodayDate today = new getTodayDate();
                EmployeePurchaseTable pur = new EmployeePurchaseTable();
                pur.setEmployeeID(user.getEmployee());
                pur.setDate(today.getDate());
                pur.setTotalRemoved(totalRemoved);
                empPurFacade.create(pur);
                for (EmployeeReceiptTable r : employeeReceiptTable) {
                    r.setPurchaseID(pur);
                    empRecFacade.create(r);
                }
            } else {
                for (ShoppingCartItem sci : user.getCart().getItems()) {
                    ReceiptTable newReceipt = new ReceiptTable();
                    System.out.println(sci.getProduct().getProductName());
                    int quantity = sci.getQuantity();
                    totalRemoved += sci.getQuantity();
                    ProductTable p = proFacade.find(sci.getProduct().getPID());
                    int currentQ = p.getStockLevel();
                    p.setStockLevel(currentQ - quantity);
                    proFacade.edit(p);
                    newReceipt.setAmountRemoved(quantity);
                    newReceipt.setCost(p.getRetailPrice() * quantity);
                    newReceipt.setProductID(p);
                    receiptTable.add(newReceipt);
                }
                for (ReceiptTable r : receiptTable) {
                    System.out.println(r.getProductID().getProductName() + ", " + r.getAmountRemoved());
                }
                getTodayDate today = new getTodayDate();
                PurchaseTable pur = new PurchaseTable();
                pur.setCustomerID(user.getCustomer());
                pur.setDate(today.getDate());
                pur.setTotalRemoved(totalRemoved);
                purFacade.create(pur);
                for (ReceiptTable r : receiptTable) {
                    r.setPurchaseID(pur);
                    recFacade.create(r);
                }
            }
            request.getRequestDispatcher("shopFront").forward(request, response);
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
