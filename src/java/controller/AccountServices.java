/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDetailDAO;
import dao.AccountDAO;
import entity.Account;
import entity.AccountDetail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Utils.RegexUtils;

/**
 *
 * @author SANG
 */
@WebServlet(name = "Account", urlPatterns = {"/servicesaccount"})
public class AccountServices extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession(true);
            String service = request.getParameter("service");

            // LOGIN
            if (service.equals("login")) {
                String email = request.getParameter("email");
                String pass = request.getParameter("password");

                // Check account in database
                Account accountLogin = new AccountDAO().login(email, pass);
                if (accountLogin != null) {
                    session.setAttribute("currentAccount", accountLogin);
                    if (accountLogin.getRoleId() == 1) {
                        System.out.println(accountLogin);
                        System.out.println("1");
                        response.sendRedirect("userlist");
                    } else if (accountLogin.getRoleId() == 2) {
                        System.out.println("2");
                        response.sendRedirect("home");
                    } else if (accountLogin.getRoleId() == 3) {
                        System.out.println("3");
                        response.sendRedirect("productservices?service=list");
                    }
                } else {
                    request.setAttribute("message", "Tài khoản email hoặc mật khẩu không đúng");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }

            // LOGOUT
            if (service.equals("logout")) {
                session.removeAttribute("currentAccount");
                response.sendRedirect("home");
            }

            // REGISTER
            if (service.equals("register")) {
                // Get in4 Account Customer
                String email = request.getParameter("email");
                String pass = request.getParameter("password");
                String passcf = request.getParameter("repassword");

                // Get in4 Account Detail
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                int gender = Integer.parseInt(request.getParameter("gender"));
                int idAccountDetail = 0;
                // Check mail validate
                if (!RegexUtils.checkEmail(email)) {
                    request.setAttribute("message", "Email không đúng định dạng");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else {
                    // Check mail in database
                    if (new AccountDAO().checkEmail(email)) {
                        request.setAttribute("message", "Email đăng ký đã tồn tại");
                        request.getRequestDispatcher("register.jsp").forward(request, response);
                    } else {
                        // Check pass and passcf
                        if (RegexUtils.checkPassValidate(pass, passcf)) {
                            AccountDetail accountDetail = new AccountDetail(name, phone, gender, address);
                            idAccountDetail = new AccountDetailDAO().addAccountDetail(accountDetail);
                            if (idAccountDetail > 0) {
                                // if the pass and passcf are passed testcase, then create new an Account
                                Account account = new Account(email, pass, idAccountDetail, 2, 1);
                                if (new AccountDAO().addAccount(account)) {
                                    request.setAttribute("message", "Đăng ký tài khoản thành công");
                                    request.getRequestDispatcher("register.jsp").forward(request, response);
                                }
                            }
                        }else{
                            request.setAttribute("message", "Mật khẩu không đúng định dạng");
                            request.getRequestDispatcher("register.jsp").forward(request, response);
                        }
                    }
                }
//                if (new AccountDAO().checkEmail(email)) {
//                    request.setAttribute("message", "Tài khoản email đã tồn tại");
//                    request.getRequestDispatcher("register.jsp").forward(request, response);
//                } else {
//                    // Check pass
//                    if (pass.equals(rePass)) {
//                        AccountDetail accountDetail = new AccountDetail(name, phone, gender, address);
//                        idAccountDetail = new AccountDetailDAO().addAccountDetail(accountDetail);
//                        if (idAccountDetail > 0) {
//                            Account account = new Account(email, pass, idAccountDetail, 2, 1);
//                            if (new AccountDAO().addAccount(account)) {
//                                System.out.println(account); // Test datas
//                                request.setAttribute("message", "Đăng ký thành công");
//                                request.getRequestDispatcher("register.jsp").forward(request, response);
//                            }
//                        }
//                    } else {
//                        request.setAttribute("message", "Nhập lại mật khẩu không khớp");
//                        request.getRequestDispatcher("register.jsp").forward(request, response);
//                    }
//                }
            }

            // RESET PASSWORD
            if (service.equals("remindpassword")) {
                String email = request.getParameter("email");
                String message = "";
                if (new AccountDAO().checkEmail(email)) {
                    System.out.println(email);
                    message = "Kiểm tra ngay email của bạn !";
                } else {
                    message = "Email không tồn tại !";
                }
                request.setAttribute("message", message);
                request.getRequestDispatcher("reset-password.jsp").forward(request, response);
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
