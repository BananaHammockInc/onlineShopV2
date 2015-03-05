/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import facadePackage.CustomerTableFacade;
import entityPackage.CustomerTable;
import facadePackage.PurchaseTableFacade;
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
 * Aaron Kelly - 12350566
 * Alex McElhinney - 12437802
 * Evan Preisler - 10101753
 * CT338 - Software Engineering Project: Banana Hammock, Online Fruit & Veg Store
 * 2015
 * 
 *
 * @author dex
 */
@WebServlet(name = "customerServlet", urlPatterns = {"/newCustomerServlet",
    "/customerServlet", "/updateCustomerDetails", "/updateCustomer"})
public class customerServlet extends HttpServlet {

    @EJB
    private CustomerTableFacade CusFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/newCustomerServlet")) {
            CustomerTable cus = new CustomerTable();
            cus.setFName(request.getParameter("FName"));
            cus.setSName(request.getParameter("SName"));
            cus.setAddressLine1(request.getParameter("AddressLine1"));
            cus.setAddressLine2(request.getParameter("AddressLine2"));
            cus.setEmail(request.getParameter("Email"));
            cus.setCity(request.getParameter("CityName"));
            cus.setPassword(request.getParameter("UserPassword"));
            cus.setCardNumber(Integer.parseInt(request.getParameter("CreditCard")));
            CusFacade.create(cus);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else if(request.getServletPath().equals("/updateCustomer")) {
            CustomerTable cus = CusFacade.find(Integer.parseInt(request.getParameter("customerEmail")));
            cus.setFName(request.getParameter("populatemeFName"));
            cus.setSName(request.getParameter("populatemeSName"));
            cus.setEmail(request.getParameter("populatemeEmail"));
            cus.setAddressLine1(request.getParameter("populatemeAddrLine1"));
            cus.setAddressLine2(request.getParameter("populatemeAddrLine2"));
            cus.setCity(request.getParameter("populatemeCity"));
            cus.setCardNumber(Integer.parseInt(request.getParameter("populatemeCreditCard")));
            CusFacade.edit(cus);
            request.getRequestDispatcher("loginOk.jsp").forward(request, response);
        }else {
            List<CustomerTable> customers = CusFacade.findAll();
            request.setAttribute("customerList", customers);
            if (request.getServletPath().equals("/customerServlet")) {
                request.getRequestDispatcher("showCustomer.jsp").forward(request, response);
            } else if (request.getServletPath().equals("/updateCustomerDetails")) {
                request.getRequestDispatcher("updateCustomerDetails.jsp").forward(request, response);
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
