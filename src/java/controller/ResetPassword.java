/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.UserlistDAO;
import entity.Account;
import entity.Email;
import forgetPassword.EmailUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.compiler.PageInfo;

/**
 *
 * @author SANG
 */
@WebServlet(name = "RemindPassword", urlPatterns = {"/remindpassword"})
public class ResetPassword extends HttpServlet {

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

//            String email = request.getParameter("email");
//            String message = "";
//            if(new AccountModel().checkEmail(email)){
//                System.out.println(email);
//                message = "Check new pass in your mail !";
//            }else{
//                message = "Email not exits !";
//            }
//            request.setAttribute("message", message);
//            request.getRequestDispatcher("remind_password.jsp").forward(request, response);
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
        request.getRequestDispatcher("reset-password.jsp").forward(request, response);
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
        try {
            String email = request.getParameter("email");
            UserlistDAO d = new UserlistDAO();
            Account a = d.getAccountbyEmail(email);
            
            if (a == null) {
                request.setAttribute("message", "Email is incorrect");
                request.getRequestDispatcher("reset-password.jsp").forward(request, response);
            } else {
                Email e = new Email();
                e.setFrom("nolifesf000@gmail.com");
                e.setFromPassword("Nolifesf1");
                e.setTo(email);
                e.setSubject("Forgot Password from online shop XXX");
                e.setContent("Tks you using forget password funcion .Your Password is : " + a.getPassword());
                EmailUtils.send(e);
                request.setAttribute("message", "Email is sended , plz check your email");
            }
        } catch (Exception e) {

        }
        request.getRequestDispatcher("reset-password.jsp").forward(request, response);
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
