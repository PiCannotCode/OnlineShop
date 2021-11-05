/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbcontext.DBContext;
import entity.OrderDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DucAnh
 */
public class OrderDetailsDAO extends DBContext {

    public ArrayList<OrderDetail> getListOrderDetails(int id) {
        ArrayList<OrderDetail> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [Order_Detail] WHERE Order_Id = ? ";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail od = new OrderDetail();
                od.setId(rs.getInt("Id"));
                od.setOrderId(rs.getInt("Order_Id"));
                od.setProductId(rs.getInt("Product_Id"));
                od.setProductName(rs.getString("Product_Name"));
                od.setProductQuantity(rs.getInt("Product_Quantity"));
                od.setProductPrice(rs.getDouble("Product_Price"));
                list.add(od);
            }
        } catch (Exception e) {
            System.err.println("Get List Order Details Fail: " + e.getMessage());
        }
        return list;
    }

}
