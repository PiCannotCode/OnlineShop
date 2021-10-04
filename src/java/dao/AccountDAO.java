/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbcontext.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SANG
 */
public class AccountDAO extends DBContext {

    ResultSet rs = null;
    PreparedStatement ps = null;

    public boolean addAccount(Account account) {
        int n = 0;
        String sql = "INSERT INTO Account(Email, [Password], Account_Detail_Id, Role_ID, [Status]) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getAccountDetailId());
            ps.setInt(4, account.getRoleId());
            ps.setInt(5, account.getStatus());
            n = ps.executeUpdate();
        } catch (Exception e) {
        }
        return n > 0;
    }

    public Account login(String email, String password) {
        String sql = "SELECT * FROM Account WHERE Email = ? and [Password] = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7)
                );
                return account;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean checkEmail(String email) {
        String sql = "SELECT * FROM Account WHERE Email = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
        }
        return false;
    }

    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> list = new ArrayList<Account>();
        String sql = "SELECT * FROM account";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7)
                );
                list.add(account);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        DBContext context = new DBContext();
        AccountDAO accountModel = new AccountDAO();
    }
}
