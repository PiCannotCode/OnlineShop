/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DucAnh
 */
@WebServlet(name = "ProductServices", urlPatterns = {"/productservices"})
public class ProductServices extends HttpServlet {

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
            String service = request.getParameter("service");

            // LIST PRODUCT
            if (service.equalsIgnoreCase("list")) {
                ProductDAO productDAO = new ProductDAO();
                ArrayList<Product> listProduct = productDAO.getListProduct("");
                request.setAttribute("listProduct", listProduct);
                request.getRequestDispatcher("products.jsp").forward(request, response);
            }

            // SEARCH PRODUCT BY NAME
            if (service.equalsIgnoreCase("search")) {
                String search = request.getParameter("searchName");
                ProductDAO productDAO = new ProductDAO();
                ArrayList<Product> listProduct = productDAO.getListProduct(search);
                request.setAttribute("listproduct", listProduct);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }

            // PRODUCT DETAILS
            if (service.equalsIgnoreCase("details")) {
                int id = Integer.parseInt(request.getParameter("id"));
                ProductDAO productDAO = new ProductDAO();
                Product product = productDAO.getProductDetail(id);
                request.setAttribute("product", product);
                request.getRequestDispatcher("product-detail.jsp").forward(request, response);
            }

            // ADD PRODUCT
            if (service.equalsIgnoreCase("add")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                int category_id = Integer.parseInt(request.getParameter("category_id"));
                float price = Float.parseFloat(request.getParameter("price"));
                String description = request.getParameter("description");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                int status = Integer.parseInt(request.getParameter("status"));
                String image = request.getParameter("image");
                String note = request.getParameter("note");
                Product product = new Product(id, name, category_id, price, description, quantity, status, image, note);
                ProductDAO productDAO = new ProductDAO();
                if (productDAO.addProduct(product)) {
                    request.setAttribute("message", "Add Product Successfully");
                    request.getRequestDispatcher("productservices?service=list").forward(request, response);
                } else {
                    request.setAttribute("message", "Add Product Fail");
                    request.getRequestDispatcher("addProduct.jsp").forward(request, response);
                }
            }

            // UPDATE PRODUCT
            if (service.equalsIgnoreCase("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                int category_id = Integer.parseInt(request.getParameter("category_id"));
                float price = Float.parseFloat(request.getParameter("price"));
                String description = request.getParameter("description");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                int status = Integer.parseInt(request.getParameter("status"));
                String image = request.getParameter("image");
                String note = request.getParameter("note");
                Product product = new Product(id, name, category_id, price, description, quantity, status, image, note);
                ProductDAO productDAO = new ProductDAO();
                if (productDAO.updateProduct(product)) {
                    request.setAttribute("message", "Update Product Successfully");
                    request.getRequestDispatcher("productservices?service=list").forward(request, response);
                } else {
                    request.setAttribute("message", "Update Product Fail");
                    request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
                }
            }

            // DETELE PRODUCT
            if (service.equalsIgnoreCase("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                ProductDAO productDAO = new ProductDAO();
                if (productDAO.deleteProduct(id)) {
                    request.setAttribute("message", "Delete Product Successfully");
                    request.getRequestDispatcher("productservices?service=list").forward(request, response);
                } else {
                    request.setAttribute("message", "Delete Product Fail");
                    request.getRequestDispatcher("productservices").forward(request, response);
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
