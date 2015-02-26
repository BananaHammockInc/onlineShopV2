/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import facadePackage.CustomerTableFacade;
import entityPackage.CustomerTable;
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
@WebServlet(name = "customerServlet", urlPatterns = {"/customerServlet", 
    "/updateCustomerDetails", "/updateCustomer"})
public class customerServlet extends HttpServlet {
    @EJB
    private CustomerTableFacade listCusTable;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CustomerTable> customers = listCusTable.findAll();
        request.setAttribute("customerList", customers);
        if(request.getServletPath().equals("/customerServlet")) {
            request.getRequestDispatcher("showCustomer.jsp").forward(request, response);
        } else if(request.getServletPath().equals("/updateCustomerDetails")) {
            request.getRequestDispatcher("updateCustomerDetails.jsp").forward(request, response);
        } else if(request.getServletPath().equals("/updateCustomer")) {
            request.getRequestDispatcher("loginOk.jsp").forward(request, response);
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
