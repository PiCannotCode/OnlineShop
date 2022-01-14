/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javax.servlet.http.HttpSession;

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
            String ran = d.givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect();
            HttpSession session = request.getSession();
            
            if (a == null) {
                request.setAttribute("message", "Email không tồn tại");
                request.getRequestDispatcher("reset-password.jsp").forward(request, response);
            } else {
                
                Email e = new Email();
                d.changePass2(email, ran);
                a = d.getAccountbyEmail(email);
                session.setAttribute("acc", a);
                e.setFrom("***");
                e.setFromPassword("***");
                e.setTo(email);
                e.setSubject("Reset Password Online Shopping System");
                e.setContent("Mật khẩu của bạn là: " + ran + ". Bạn nên thay đổi mật khẩu sau khi đăng nhập lại.");
                EmailUtils.send(e);
                request.getRequestDispatcher("Code.jsp").forward(request, response);
            }
        } catch (Exception e) {

        }
        request.getRequestDispatcher("Code.jsp").forward(request, response);
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
