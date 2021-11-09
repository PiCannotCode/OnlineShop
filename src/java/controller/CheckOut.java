/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserlistDAO;
import entity.Account;
import entity.Cart;
import entity.Order;
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
 * @author hanoon
 */
@WebServlet(name = "CheckOut", urlPatterns = {"/CheckOut"})
public class CheckOut extends HttpServlet {

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
        HttpSession session = request.getSession();
        Account accountLogin = (Account) session.getAttribute("currentAccount");
        int id = accountLogin.getId();
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        String email = request.getParameter("email");
        double price = Double.parseDouble(request.getParameter("totalprice"));
        float ship = Float.parseFloat(request.getParameter("ship"));
        float VAT = Float.parseFloat(request.getParameter("vat"));
        float pay = Float.parseFloat(request.getParameter("totalpays"));
        String phone = request.getParameter("phone");
        int payment = 1;
        String none = "none";
        int status = 1;

        UserlistDAO d = new UserlistDAO();

        d.addCheckOut(new Order(id, price, note, status, address, name, phone, email, ship, VAT, pay, payment, none));
        int Oid = d.getMax().getId();
        ArrayList<Cart> listCart = null;
        listCart = (ArrayList<Cart>) session.getAttribute("listCart");
        for (Cart cart : listCart) {
            int Pid = cart.getProductId();
            int QuantityLeft = d.getQuantity(Pid).getQuantity();
            int Pquantity = cart.getQuantity();
            int ChangeQuantity = QuantityLeft-Pquantity;
            d.changeQuantity(ChangeQuantity, Pid);
            double Pprice = cart.getUnitPrice();
            String Pname = cart.getName();
            d.addOrderDetail(new OrderDetail(Oid, Pid, Pname, Pquantity, price));
        }

        request.getRequestDispatcher("home").forward(request, response);

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
