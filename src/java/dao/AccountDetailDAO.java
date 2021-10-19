/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbcontext.DBContext;
import entity.AccountDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author SANG
 */
public class AccountDetailDAO extends DBContext {

    ResultSet rs = null;
    PreparedStatement ps = null;

    public int addAccountDetail(AccountDetail accountDetail) {
        String sql = "INSERT INTO Account_Detail(Name, Phone_Number, Gender, Address) VALUES(?, ?, ?, ?)";
        try {
            // Declare statement.return_generated_keys to control program jdbc return the keys
            ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, accountDetail.getName());
            ps.setString(2, accountDetail.getPhone());
            ps.setInt(3, accountDetail.getGender());
            ps.setString(4, accountDetail.getAddress());
            int n = ps.executeUpdate();
            if (n > 0) {
                // Fields PK id in table accDetail set is auto increment
                rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public AccountDetail getAccountById(int id) {
        AccountDetail accDetail = new AccountDetail();
        try {
            String sql = "SELECT * FROM Account_Detail WHERE Id = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accDetail.setId(rs.getInt("Id"));
                accDetail.setName(rs.getString("Name"));
                accDetail.setPhone(rs.getString("Phone_Number"));
                accDetail.setGender(rs.getInt("Gender"));
                accDetail.setAddress(rs.getString("Address"));
            }
        } catch (Exception e) {
            System.out.println("Get Account Detail Fail: " + e.getMessage());
        }
        return accDetail;
    }
    
    public boolean editProfile(AccountDetail accDetail) {
        try {
            String sql = "UPDATE Account_Detail SET Name= ? ,Phone_Number= ? ,Gender= ? ,Address= ? "
                    + "WHERE Id= ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, accDetail.getName());
            ps.setString(2, accDetail.getPhone());
            ps.setInt(3, accDetail.getGender());
            ps.setString(4, accDetail.getAddress());
            ps.setInt(5, accDetail.getId());
            int flag = ps.executeUpdate();
            return flag >= 1;
        } catch (Exception e) {
            System.err.println("Edit Profile Fail: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Test datas
        AccountDetailDAO accountDetailModel = new AccountDetailDAO();
        accountDetailModel.addAccountDetail(new AccountDetail("Sang", "0768668386", 1, "Quang Ninh"));
    }
}
