/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
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
@WebServlet(name = "Addtocart", urlPatterns = {"/cartservice"})
public class CartService extends HttpServlet {

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
                try {
                    String id = session.getAttribute("currentAccount").toString();
                } catch (Exception e) {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

                session = request.getSession();
                int id = Integer.parseInt(request.getParameter("id"));
                System.out.println(id);
                Product pro = new ProductDAO().getProductDetail(id);
                System.out.println(pro);
                Cart cart = new Cart(pro.getId(), pro.getName(), pro.getPrice(), 1);
                System.out.println(cart);
                ArrayList<Cart> listCart = null;
                listCart = (ArrayList<Cart>) session.getAttribute("listCart");

                boolean flag = true;
                if (listCart == null) {
                    listCart = new ArrayList<>();
                    listCart.add(cart);
                    session.setAttribute("listCart", listCart);
                } else {
                    for (Cart c : listCart) {
                        if (c.getProductId() == id) {
                            c.setQuantity(c.getQuantity() + 1);
                            flag = false;
                        }
                    }
                    if (flag == true) {
                        listCart.add(cart);
                    }
                    session.setAttribute("listCart", listCart);
                }
                // Loi cart lien quan den fillter cua Tuyen
//                int id = Integer.parseInt(request.getParameter("id"));
                //                Product pro = (Product) session.getAttribute(String.valueOf(id));
                //
                //                if (pro == null) {
                //                    Product pro2 = new ProductDAO().getProductDetail(id);
                //                    pro2.setQuantity(1);
                //                    session.setAttribute("id", pro2);
                //                    request.getRequestDispatcher("cart.jsp").forward(request, response);
                //                } else {// bug here
                //                    pro.setQuantity(pro.getQuantity() + 1);
                //                    request.getRequestDispatcher("cart.jsp").forward(request, response);
                //                }
//                request.getRequestDispatcher("cart.jsp").forward(request, response);
                response.sendRedirect("home");
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
