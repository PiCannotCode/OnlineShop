/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dbcontext.DBContext;
import entity.Account;
import entity.AccountAll;
import entity.Cart;
import entity.Max;
import java.sql.Connection;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Order;
import entity.OrderDetail;

/**
 *
 * @author hanoon
 */
public class UserlistDAO {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public ArrayList<AccountAll> getAllAccountUser() {
        ArrayList<AccountAll> list = new ArrayList<AccountAll>();
        String sql = "select Account.Id , Email ,[Role].Name as [role], Status_Account.[Status] , Create_Date , Account_Detail.[name] , Phone_Number , Gender ,[Address] from Account , Account_Detail , [Role] ,"
                + " Status_Account where Account.Account_Detail_Id = Account_Detail.Id and [role].id=account.Role_ID and Status_Account.id = Account.Status";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(sql);//nem cau lenh query sang sql
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                list.add(new AccountAll(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getString(9)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public Account getAccountAllbyid(String id) {
        String query = "select* from account where id = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setString(1, id);
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void editAccount(String email, int isAdmin) {
        String query = "update Account set Role_ID=? where email=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, isAdmin);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteAcc(String id) {
        String query = "delete from Account where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
        }
    }

    public ArrayList<Order> getIdOrder(String id) {
        ArrayList<Order> list = new ArrayList<Order>();
        String sql = "select Account_Id from [Order] where Account_Id=?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(sql);//nem cau lenh query sang sql
            ps.setString(1, id);
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                list.add(new Order(rs.getInt(1)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public void changePass(int id, String pass, String newpass) {
        String query = "update Account set [Password]=? where id = ? and [Password]=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, newpass);
            ps.setInt(2, id);
            ps.setString(3, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
        public void changePass2(String email, String pass) {
        String query = "update Account set [Password]=? where Email=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    

    public Account getAccountbyid(int id) {
        String query = "select* from account where id = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setInt(1, id);
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account getAccountbyEmail(String Email) {
        String query = "select* from account where Email = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setString(1, Email);
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean addCheckOut(Order order) {
        String query = "insert into [Order] (Account_Id, Total_Price, Note, [Status], [Address],[name], Phone,Email,Ship,VAT,Total_Pay,Payments,Reason_Cancelltion) \n"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, order.getAccountId());
            ps.setDouble(2, order.getTotalPrice());
            ps.setString(3, order.getNote());
            ps.setInt(4, order.getStatus());
            ps.setString(5, order.getAddress());
            ps.setString(6, order.getName());
            ps.setString(7, order.getPhone());
            ps.setString(8, order.getEmail());
            ps.setFloat(9, order.getShip());
            ps.setFloat(10, order.getVat());
            ps.setFloat(11, order.getTotalPay());
            ps.setInt(12, order.getPayments());
            ps.setString(13, order.getReasonCancle());
            int n = ps.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    public boolean addOrderDetail(OrderDetail Or) {
        String query = "insert into Order_Detail(Order_Id,Product_Id,Product_Name,Product_Quantity,Product_Price)\n"
                + "values(?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, Or.getOrderId());
            ps.setInt(2, Or.getProductId());
            ps.setString(3, Or.getProductName());
            ps.setInt(4, Or.getProductQuantity());
            ps.setDouble(5, Or.getProductPrice());
            int n = ps.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    public Max getMax() {
        String query = "select top 1 id  from [Order] order by id desc";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                return new Max(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Cart getQuantity(int id) {
        String query = "select Quantity from Products where id =?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setInt(1, id);
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                return new Cart(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void changeQuantity(int quantity, int id) {
        String query = "update Products set Quantity =? where Id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void changeStatusProduct(int id) {
        String query = "update Products set Status =? where Id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, 0);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public String givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

       
        return generatedString;
    }

    public static void main(String[] args) {
        UserlistDAO d = new UserlistDAO();
//        d.addCheckOut(new Order(24,100 , "aaa", 1, "123a", "manh", "0123123123", "ass@gmail.com", 100, 100,100, 1, "none"));
////        int t = d.getMax().getId();
////        System.out.println(d.token());
//        d.addOrderDetail(new OrderDetail(18, 11, "manh", 100, 300));
        d.givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect();
    }

}
