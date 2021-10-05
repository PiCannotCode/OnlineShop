/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Product;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Cart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SANG
 */
@WebServlet(name = "Addtocart", urlPatterns = {"/addtocart"})
public class Addtocart extends HttpServlet {

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

            HttpSession session = request.getSession();
            String service = request.getParameter("service");

            // ADDTOCART
            if (service.equals("taketocart")) {
                // CHECK USER LOGIN
                try {
                    String id = session.getAttribute("currentAccount").toString();
                } catch (NullPointerException e) {
                    response.sendRedirect("login.jsp");
                    return;
                }

                // LIST<CART>
                int id = Integer.parseInt(request.getParameter("id"));
                Product pro  = new ProductDAO().getProductDetail(id);
                Cart cart = new Cart(id, pro.getName(), pro.getPrice(), 1);
                
                session = request.getSession();
                List<Cart> list = null;
                list = (ArrayList<Cart>) session.getAttribute("listCart");
                
                boolean flag = true;
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(cart);
                    session.setAttribute("listCart", list);
                }else{
                    for (Cart c : list) {
                        if (c.getProductId()== id) {
                            c.setQuantity(c.getQuantity() + 1);
                            flag = false;
                        }
                    }
                    if (flag) {
                        list.add(cart);
                        flag = true;
                    }
                    session.setAttribute("listCart", list);
                }
                
//                int id = Integer.parseInt(request.getParameter("id"));
//                Product pro = session.getAttribute(id);
//
//                // DOES NOT HAVE THIS PRODUCT (OR KEY, VALUE) YET;
//                if (pro == null) {
//                    Product pro2 = new ProductDAO().getProductDetail(id);
//                    pro2.setQuantity(1);
//                    session.setAttribute(id, pro2);
//                    request.getRequestDispatcher("cart.jsp").forward(request, response);
//                } else {
//                    // THE CART HAVE THIS PRODUCT ALREADY
//                    // AND ADD 1 TO NUMBER OF ITEMS
//                    pro.setQuantity(pro.getQuantity() + 1);
//                    request.getRequestDispatcher("cart.jsp").forward(request, response);
//                }
            }

            // TAKE 1 ITEM FROM CART
            if (service.equals("takefromcart")) {
                String id = request.getParameter("id");
                Product pro = (Product) session.getAttribute(id);
                // Đang bị lỗi dấu trừ
                if (pro.getQuantity() == 1) {
                    session.removeAttribute(id);
                    response.sendRedirect("cart.jsp");
//                    response.sendRedirect("remove.jsp?id=" +  id);
                } else {
                    pro.setQuantity(pro.getQuantity() - 1);
                    response.sendRedirect("cart.jsp");
                }
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
