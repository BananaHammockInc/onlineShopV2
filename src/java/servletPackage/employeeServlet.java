/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import entityPackage.Employee;
import facadePackage.EmployeeFacade;
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
@WebServlet(name = "employeeServlet", urlPatterns = {"/employeeServletPage", "/ListEmployee"})
public class employeeServlet extends HttpServlet {

    @EJB
    private EmployeeFacade EmpFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/employeeServletPage")) {
            Employee newEmp = new Employee();
            newEmp.setFName(request.getParameter("FName"));
            newEmp.setSName(request.getParameter("SName"));
            newEmp.setEmail(request.getParameter("Email"));
            newEmp.setAddressLine1(request.getParameter("AddressLine1"));
            newEmp.setAddressLine2(request.getParameter("AddressLine2"));
            newEmp.setCity(request.getParameter("CityName"));
            newEmp.setPassword(request.getParameter("UserPassword"));
            newEmp.setContactNumber(Integer.parseInt(request.getParameter("ContactNum")));
            newEmp.setRoleInCompany(request.getParameter("RoleInCompany"));
            newEmp.setSalary(Double.parseDouble(request.getParameter("Salary")));
            EmpFacade.create(newEmp);
            request.getRequestDispatcher("ListEmployee").forward(request, response);
        } else if(request.getServletPath().equals("/ListEmployee")) {
            List employees = EmpFacade.findAll();
            request.setAttribute("employeeList", employees);
            request.getRequestDispatcher("showEmployee.jsp").forward(request, response);
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
