/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;

import entityPackage.EmployeePurchaseTable;
import entityPackage.EmployeeReceiptTable;
import entityPackage.PurchaseTable;
import entityPackage.ReceiptTable;
import customObject.purchaseController;
import facadePackage.EmployeePurchaseTableFacade;
import facadePackage.EmployeeReceiptTableFacade;
import facadePackage.PurchaseTableFacade;
import facadePackage.ReceiptTableFacade;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "purchaseServlet", urlPatterns = {"/allPurchases", "/getReceipt"})
public class purchaseServlet extends HttpServlet {
    @EJB
    private EmployeePurchaseTableFacade empPurFacade;
    @EJB
    private EmployeeReceiptTableFacade empRecFacade;
    @EJB
    private PurchaseTableFacade purFacade;
    @EJB
    private ReceiptTableFacade recFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/allPurchases")) {
            purchaseController pc = new purchaseController();
            List<PurchaseTable> purchaseC = purFacade.findAll();
            List<EmployeePurchaseTable> purchaseE = empPurFacade.findAll();
            pc.setPurchase(purchaseC);
            pc.setPurchaseE(purchaseE);
            request.setAttribute("haveAllPurchases", pc);
            request.getRequestDispatcher("showAllPurchase.jsp").forward(request, response);
        } else if(request.getServletPath().equals("/getReceipt")) {
            int empReceiptNumber = -1;
            int cusReceiptNumber = -1;
            int purchaseNumber = 0;
            try {
                empReceiptNumber = Integer.parseInt(request.getParameter("employeeID"));
                purchaseNumber = Integer.parseInt(request.getParameter("purchaseID"));
            } catch (Exception ex) {}
            try {
                cusReceiptNumber = Integer.parseInt(request.getParameter("customerID"));
                purchaseNumber = Integer.parseInt(request.getParameter("purchaseID"));
            } catch (Exception ex) {}
            if(empReceiptNumber > -1) {
                List<EmployeeReceiptTable> receiptE = empRecFacade.findAll();
                List<EmployeeReceiptTable> currentEmployee = new ArrayList<EmployeeReceiptTable>();
                for(EmployeeReceiptTable x : receiptE) {
                    if(x.getPurchaseID().getEmployeeID().getPkID().equals(empReceiptNumber) &&
                            x.getPurchaseID().getPuID().equals(purchaseNumber)) {
                        currentEmployee.add(x);
                    }
                }
                request.setAttribute("receipt", currentEmployee);
                request.getRequestDispatcher("showReceiptResults.jsp").forward(request, response);
            } else if(cusReceiptNumber > -1) {
                List<ReceiptTable> receiptC = recFacade.findAll();
                List<ReceiptTable> currentCustomer = new ArrayList<ReceiptTable>();
                for(ReceiptTable x : receiptC) {
                    if(x.getPurchaseID().getCustomerID().getCID().equals(cusReceiptNumber) &&
                            x.getPurchaseID().getPuID().equals(purchaseNumber)) {
                        currentCustomer.add(x);
                    }
                }
                request.setAttribute("receipt", currentCustomer);
                request.getRequestDispatcher("showReceiptResults.jsp").forward(request, response);
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
