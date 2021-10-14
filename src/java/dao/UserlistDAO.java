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
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String sql = "select Account.Id , Email ,[Role].Name as [role], Status_Account.[Status] , Create_Date , Account_Detail.[name] , Phone_Number , Gender ,[Address] from Account , Account_Detail , [Role] , Status_Account where Account.Id = Account_Detail.Id and [role].id=account.Role_ID and Status_Account.id = Account.Role_ID ";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(sql);//nem cau lenh query sang sql
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                list.add(new AccountAll(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8), rs.getString(9)));
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

    public static void main(String[] args) {
        UserlistDAO d = new UserlistDAO();
        System.out.println(d.getAllAccountUser());
    }
}
