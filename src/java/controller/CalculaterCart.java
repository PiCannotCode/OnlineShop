/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Cart;
import entity.Product;
import dao.ProductDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SANG
 */
@WebServlet(name = "CalculaterCart", urlPatterns = {"/CalculaterCart"})
public class CalculaterCart extends HttpServlet {

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
            int service = Integer.parseInt(request.getParameter("service"));
            HttpSession session = request.getSession();

            ArrayList<Cart> listCart = null;
            listCart = (ArrayList<Cart>) session.getAttribute("listCart");

            if (service == 0) {
                for (int i = 0; i < listCart.size(); i++) {
                    if (listCart.get(i).getProductId() == id) {
                        listCart.remove(i);
                    }
                }
                request.setAttribute("listCart", listCart);
            }

            for (int i = 0; i < listCart.size(); i++) {
                if (listCart.get(i).getProductId() == id) {
                    if (service == 1) {
                        listCart.get(i).setQuantity(listCart.get(i).getQuantity() - 1);
                        if (listCart.size() > 1) {
                            if (listCart.get(i).getQuantity() == 0) {
                                listCart.remove(i);
                            }
                        } else {
                            if (listCart.get(i).getQuantity() == 0) {
                                listCart.remove(i);
                            }
                        }
                        session.setAttribute("listCart", listCart);
                    }
                    if (service == 2) {
                        Product pro = new ProductDAO().getProductDetail(id);
                        if (listCart.get(i).getQuantity() < pro.getQuantity()) {
                            listCart.get(i).setQuantity(listCart.get(i).getQuantity() + 1);
                        } else {
                            listCart.get(i).setQuantity(listCart.get(i).getQuantity());
                        }
                        session.setAttribute("listCart", listCart);
                    }
                }
            }
            double totalprice = 0;
            for (Cart c1 : listCart) {
                int s = c1.getQuantity();
                totalprice = totalprice + c1.getUnitPrice() * s;
            }
            double totalpays = 0;
            totalpays = totalprice + 50000;
            session.setAttribute("listCart", listCart);
            session.setAttribute("totalprice", totalprice);
            session.setAttribute("totalpays", totalpays);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
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
