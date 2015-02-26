/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import entityPackage.Employee;
import entityPackage.CustomerTable;
import facadePackage.EmployeeFacade;
import facadePackage.CustomerTableFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dex
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
    @EJB
    private EmployeeFacade empCheck;
    @EJB
    private CustomerTableFacade cusCheck;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] oldCookies = request.getCookies();
        for(int i = 0; i < oldCookies.length; i++){
            System.out.println(oldCookies[i].toString());
            oldCookies[i].setMaxAge(0);
        }        
        String email = request.getParameter("Email");
        String password = request.getParameter("UserPassword");
        int type = -1;
        List<Employee> employees = empCheck.findAll();
        for(Employee e : employees){
            if((e.getEmail().equals(email)) && (e.getPassword().equals(password))) {
                Cookie user = new Cookie("email", email);
                Cookie level = new Cookie("admin", "admin");
                //setting cookie to expiry in 30 mins
                user.setMaxAge(30*60);
                level.setMaxAge(30*60);
                response.addCookie(user);
                response.addCookie(level);
                type = 1;
                break;
            }
        }
        if(type < 0) {
            List<CustomerTable> customers = cusCheck.findAll();
            for(CustomerTable c : customers) {
                if(c.getEmail().equals(email) && c.getPassword().equals(password)) {
                    Cookie user = new Cookie("email", email);
                    Cookie level = new Cookie("notAdmin", "not an admin");
                    user.setMaxAge(30*60);
                    level.setMaxAge(30*60);
                    response.addCookie(user);
                    response.addCookie(level);
                    type = 2;
                    break;
                }
            }
        }
        if(type == 1) {
            request.getRequestDispatcher("loginOk.jsp").forward(request, response);
        } else if (type == 2) {
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
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
