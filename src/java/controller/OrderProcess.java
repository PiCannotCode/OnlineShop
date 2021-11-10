/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDAO;
import dao.OrderDetailsDAO;
import dao.ProductDAO;
import entity.Account;
import entity.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DucAnh
 */
@WebServlet(name = "OrderProcess", urlPatterns = {"/orderProcess"})
public class OrderProcess extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("id"));
            int status = Integer.parseInt(request.getParameter("status"));
            OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
            ArrayList<OrderDetail> odList = orderDetailsDAO.getListOrderDetails(id);
            if(status == 4){
                for(OrderDetail od : odList){
                    int productID = od.getProductId();
                    int quantity = od.getProductQuantity();
                    ProductDAO productDAO = new ProductDAO();
                    productDAO.restoreProductQuantity(productID,quantity,1);
                }
            }
            OrderDAO orderDAO = new OrderDAO();
            orderDAO.updateStatus(id, status);
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("currentAccount");
            if ((int)account.getRoleId() == 3) {
                request.getRequestDispatcher("orderListServlet").forward(request, response);
            } else {
                request.getRequestDispatcher("MyOrderServlet?id="+(int)account.getId()+"").forward(request, response);
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
