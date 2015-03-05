/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import cartPackage.ShoppingCart;
import entityPackage.Employee;
import entityPackage.CustomerTable;
import customObject.userSession;
import entityPackage.SupplierTable;
import facadePackage.EmployeeFacade;
import facadePackage.CustomerTableFacade;
import facadePackage.SupplierTableFacade;
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
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    @EJB
    private EmployeeFacade empCheck;
    @EJB
    private CustomerTableFacade cusCheck;
    @EJB
    private SupplierTableFacade supCheck;
    private userSession us;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        us = new userSession();
        ShoppingCart cart = new ShoppingCart();
        String email = request.getParameter("Email");
        String password = request.getParameter("UserPassword");
        int type = -1;
        List<Employee> employees = empCheck.findAll();
        for (Employee e : employees) {
            if ((e.getEmail().equals(email)) && (e.getPassword().equals(password))) {
                us.setCart(cart);
                us.setEmployee(e);
                type = 1;
                break;
            }
        }
        if(type < 0) {
            List<SupplierTable> suppliers = supCheck.findAll();
            for(SupplierTable s : suppliers) {
                if((s.getBusinessName().equals(email)) && (s.getPassword().equals(password))){
                    us.setSupplier(s);
                    type = 2;
                    break;
                }
            }
        }
        if (type < 0) {
            List<CustomerTable> customers = cusCheck.findAll();
            for (CustomerTable c : customers) {
                if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                    us.setCart(cart);
                    us.setCustomer(c);
                    type = 3;
                    break;
                }
            }
        }
        System.out.println(us.getEmployee().getEmail());
        HttpSession session = request.getSession();
        session.setAttribute("user", us);
        if (type == 1) {
            request.getRequestDispatcher("loginOk.jsp").forward(request, response);
        } else if(type == 2) {
            request.getRequestDispatcher("supplierLogin.jsp").forward(request, response);
        } else if (type == 3) {
            request.getRequestDispatcher("shopFront").forward(request, response);
        } else {
            request.getRequestDispatcher("loginFail.jsp").forward(request, response);
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
