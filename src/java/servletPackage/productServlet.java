/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import entityPackage.ProductTable;
import facadePackage.ProductTableFacade;
import cartPackage.ShoppingCart;
import customObject.userSession;
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
 * Aaron Kelly - 12350566
 * Alex McElhinney - 12437802
 * Evan Preisler - 10101753
 * CT338 - Software Engineering Project: Banana Hammock, Online Fruit & Veg Store
 * 2015
 * 
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
        userSession user = (userSession) session.getAttribute("user");
        if (request.getServletPath().equals("/shopFront")) {
            request.setAttribute("productList", products);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/viewCart")) {
            if (user == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            user.getCart().calculateTotal("0.0");
            request.setAttribute("cart", user.getCart());
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/productServlet")) {
            request.getRequestDispatcher("showProduct.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/updateStockLevelServlet")) {
            request.getRequestDispatcher("updateStockLevel.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/updateProductTableServlet")) {
            int pid = Integer.parseInt(request.getParameter("productID"));
            try {
                int stockLevel = Integer.parseInt(request.getParameter("updateValue"));
                if(stockLevel < 0 ) stockLevel = 0;
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
