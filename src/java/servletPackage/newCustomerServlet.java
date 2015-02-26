/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import entityPackage.CustomerTable;
import facadePackage.CustomerTableFacade;
import java.io.IOException;
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
@WebServlet(name = "newCustomerServlet", urlPatterns = {"/newCustomerServlet"})
public class newCustomerServlet extends HttpServlet {
    @EJB
    private CustomerTableFacade newCusFacade; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int creaditCard = Integer.parseInt(request.getParameter("CreditCard"));
        CustomerTable cus = new CustomerTable();
        cus.setFName(request.getParameter("FName"));
        cus.setSName(request.getParameter("SName"));
        cus.setAddressLine1(request.getParameter("AddressLine1"));
        cus.setAddressLine2(request.getParameter("AddressLine2"));
        cus.setEmail(request.getParameter("Email"));
        cus.setCity(request.getParameter("CityName"));
        cus.setPassword(request.getParameter("UserPassword"));
        cus.setCardNumber(creaditCard);
        
        newCusFacade.create(cus);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
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
