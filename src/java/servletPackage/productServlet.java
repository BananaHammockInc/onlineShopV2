/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import entityPackage.ProductTable;
import facadePackage.ProductTableFacade;
import cartPackage.ShoppingCart;
import java.io.IOException;
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
 * @author dex
 */
@WebServlet(name = "productServlet", urlPatterns = {"/productServlet",
    "/updateStockLevelServlet", "/updateProductTableServlet", 
    "/shopFront", "/viewCart"})
public class productServlet extends HttpServlet {

    @EJB
    private ProductTableFacade listProTable;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List products = listProTable.findAll();
        request.setAttribute("productList", products);
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (request.getServletPath().equals("/shopFront")) {
            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }
            request.setAttribute("productList", products);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/viewCart")) {
            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }
            
            cart.calculateTotal("0.0");
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
            
        } else if (request.getServletPath().equals("/productServlet")) {
            request.getRequestDispatcher("showProduct.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/updateStockLevelServlet")) {
            request.getRequestDispatcher("updateStockLevel.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/updateProductTableServlet")) {
            int pid = Integer.parseInt(request.getParameter("productID"));
            try {
                int stockLevel = Integer.parseInt(request.getParameter("updateValue"));
                ProductTable p = listProTable.find(pid);
                p.setStockLevel(stockLevel);
                listProTable.edit(p);
                products = listProTable.findAll();
                request.setAttribute("productList", products);
                request.getRequestDispatcher("showProduct.jsp").forward(request, response);
            } catch (Exception ex) {
                request.getRequestDispatcher("loginOk.jsp").forward(request, response);
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
