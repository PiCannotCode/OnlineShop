/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.Category;
import java.util.ArrayList;
import dbcontext.DBContext;

/**
 *
 * @author SANG
 */
public class CategoryDAO extends DBContext {

    ResultSet rs = null;
    PreparedStatement ps = null;

    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Categories";
        try {
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt(1),
                        rs.getString(2)
                );
                list.add(category);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM Categories WHERE Id = ?";
        try {
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt(1),
                        rs.getString(2)
                );
                return category;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        CategoryDAO cate = new CategoryDAO();
        ArrayList<Category> list = cate.getAllCategory();
        
    }
}
