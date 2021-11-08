/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbcontext.DBContext;
import entity.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author SANG
 */
public class OrderDAO extends DBContext {

    ResultSet rs = null;
    PreparedStatement ps = null;

    public boolean insertOrder(Order order) {
        int n = 0;
        String sql = "insert into [Order](Account_Id, Total_Price, Note, [Status], [Address], [Name], "
                + "Phone, Email, Ship, VAT, Total_Pay, Payments) values(?,?,?,?,?,?,?,?,?,?,?,?)\n";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
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
            ps.setString(12, order.getReasonCancle());
            n = ps.executeUpdate();
        } catch (Exception e) {
        }
        return n > 0;
    }

    public ArrayList<Order> getListOrder() {
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [Order]";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("Id"));
                order.setAccountId(rs.getInt("Account_Id"));
                order.setDate(rs.getString("Create_Date"));
                order.setTotalPrice(rs.getDouble("Total_Price"));
                order.setNote(rs.getString("Note"));
                order.setStatus(rs.getInt("Status"));
                order.setAddress(rs.getString("Address"));
                order.setName(rs.getString("Name"));
                order.setPhone(rs.getString("Phone"));
                order.setEmail(rs.getString("Email"));
                order.setShip(rs.getFloat("Ship"));
                order.setVat(rs.getFloat("VAT"));
                order.setTotalPay(rs.getFloat("Total_Pay"));
                order.setPayments(rs.getInt("Payments"));
                order.setReasonCancle(rs.getString("Reason_Cancelltion"));
                listOrder.add(order);
            }
        } catch (Exception e) {
            System.err.println("Get List Order Fail: " + e.getMessage());
        }
        return listOrder;
    }
    
    public ArrayList<Order> getListOrderByAccountId(int id) {
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [Order] WHERE Account_Id = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("Id"));
                order.setAccountId(rs.getInt("Account_Id"));
                order.setDate(rs.getString("Create_Date"));
                order.setTotalPrice(rs.getDouble("Total_Price"));
                order.setNote(rs.getString("Note"));
                order.setStatus(rs.getInt("Status"));
                order.setAddress(rs.getString("Address"));
                order.setName(rs.getString("Name"));
                order.setPhone(rs.getString("Phone"));
                order.setEmail(rs.getString("Email"));
                order.setShip(rs.getFloat("Ship"));
                order.setVat(rs.getFloat("VAT"));
                order.setTotalPay(rs.getFloat("Total_Pay"));
                order.setPayments(rs.getInt("Payments"));
                order.setReasonCancle(rs.getString("Reason_Cancelltion"));
                listOrder.add(order);
            }
        } catch (Exception e) {
            System.err.println("Get List Order By Account_Id Fail: " + e.getMessage());
        }
        return listOrder;
    }
}
