/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import dbcontext.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DucAnh
 */
public class ProductDAO extends DBContext {

    ResultSet rs = null;
    PreparedStatement ps = null;

    public ArrayList<Product> getListProduct(String search) {
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Products";
            if (!search.trim().isEmpty()) {
                sql += " WHERE name LIKE '%" + search + "%'";
            }
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("Id"));
                product.setName(rs.getString("Name"));
                product.setCategory_id(rs.getInt("Category_Id"));
                product.setPrice(rs.getInt("Price"));
                product.setDescription(rs.getString("Description"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setStatus(rs.getInt("Status"));
                product.setImage(rs.getString("Image"));
                product.setNote(rs.getString("Note"));
                listProduct.add(product);
            }
        } catch (Exception e) {
            System.err.println("Get List Product Fail: " + e.getMessage());
        }
        return listProduct;
    }

    public Product getProductDetail(int id) {
        Product product = new Product();
        try {
            String sql = "SELECT * FROM Products WHERE Id = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product.setId(rs.getInt("Id"));
                product.setName(rs.getString("Name"));
                product.setCategory_id(rs.getInt("Category_Id"));
                product.setPrice(rs.getInt("Price"));
                product.setDescription(rs.getString("Description"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setStatus(rs.getInt("Status"));
                product.setImage(rs.getString("Image"));
                product.setNote(rs.getString("Note"));
            }
        } catch (Exception e) {
            System.err.println("Get Product Fail: " + e.getMessage());
        }
        return product;
    }

    public Product getProductTop1() {
        Product product = new Product();
        try {
            String sql = "select top 1 * from Products order by id desc";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product.setId(rs.getInt("Id"));
                product.setName(rs.getString("Name"));
                product.setCategory_id(rs.getInt("Category_Id"));
                product.setPrice(rs.getInt("Price"));
                product.setDescription(rs.getString("Description"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setStatus(rs.getInt("Status"));
                product.setImage(rs.getString("Image"));
                product.setNote(rs.getString("Note"));
            }
        } catch (Exception e) {
            System.err.println("Get Product Fail: " + e.getMessage());
        }
        return product;
    }
    
    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try {
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)
                );
                list.add(product);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> getAllProductByCategory(int id) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE Category_Id = ?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)
                );
                list.add(product);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public boolean addProduct(Product product) {
        try {
            String sql = "INSERT INTO Products VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getCategory_id());
            ps.setFloat(3, product.getPrice());
            ps.setString(4, product.getDescription());
            ps.setInt(5, product.getQuantity());
            ps.setString(6, product.getStatus());
            ps.setString(7, product.getImage());
            ps.setString(8, product.getNote());
            int flag = ps.executeUpdate();
            if (flag >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Add Product Fail: " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateProduct(Product product) {
        try {
            String sql = "UPDATE Products SET Name= ? ,Category_Id= ? ,Price= ? ,Description= ? ,Quantity= ? ,Status= ? ,Image= ? ,Note= ? "
                    + "WHERE Id= ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getCategory_id());
            ps.setFloat(3, product.getPrice());
            ps.setString(4, product.getDescription());
            ps.setInt(5, product.getQuantity());
            ps.setString(6, product.getStatus());
            ps.setString(7, product.getImage());
            ps.setString(8, product.getNote());
            ps.setInt(9, product.getId());
            int flag = ps.executeUpdate();
            if (flag >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Update Product Fail: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteProduct(int id) {
        try {
            String sql = "DELETE FROM Products WHERE Id= ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            int flag = ps.executeUpdate();
            if (flag >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Delete Product Fail: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        Product pro = dao.getProductDetail(1);
        System.out.println(pro);
    }
}
