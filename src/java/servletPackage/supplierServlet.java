/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import entityPackage.ProductTable;
import facadePackage.ProductTableFacade;
import entityPackage.SupplierTable;
import facadePackage.SupplierTableFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dex
 */
@WebServlet(name = "productSupplierServlet", urlPatterns = {"/newProductServlet",
    "/supplierServlet", "/addNewProduct", "/newSupplierServlet"})
public class supplierServlet extends HttpServlet {

    @EJB
    private SupplierTableFacade SupTable;
    @EJB
    private ProductTableFacade ProTable;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/newProductServlet")) {
            SupplierTable getSup = SupTable.find(Integer.parseInt(request.getParameter("supplierName")));
            ProductTable newProduct = new ProductTable();
            newProduct.setProductName(request.getParameter("productName"));
            newProduct.setDescription(request.getParameter("description"));
            newProduct.setWholesalePrice(Double.parseDouble(request.getParameter("wholesalePrice")));
            newProduct.setRetailPrice(Double.parseDouble(request.getParameter("retailPrice")));
            newProduct.setStockLevel(Integer.parseInt(request.getParameter("stockLevel")));
            newProduct.setSupplierID(getSup);
            ProTable.create(newProduct);
            request.getRequestDispatcher("productServlet").forward(request, response);
        } else if (request.getServletPath().equals("/newSupplierServlet")) {
            SupplierTable sup = new SupplierTable();
            sup.setBusinessName(request.getParameter("BusinessName"));
            sup.setPassword(request.getParameter("UserPassword"));
            SupTable.create(sup);
            request.getRequestDispatcher("loginOk.jsp").forward(request, response);
        } else {
            List<SupplierTable> suppliers = SupTable.findAll();
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
