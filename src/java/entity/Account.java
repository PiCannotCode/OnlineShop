/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author SANG
 */
public class Account {

    private int id;
    private String email;
    private String password;
    private int accountDetailId;
    private int roleId;
    private int status;
    private String createDate;

    public Account(int id, String email, String password, int accountDetailId, int roleId, int status, String createDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.accountDetailId = accountDetailId;
        this.roleId = roleId;
        this.status = status;
        this.createDate = createDate;
    }

    public Account(String email, String password, int accountDetailId, int roleId, int status) {
        this.email = email;
        this.password = password;
        this.accountDetailId = accountDetailId;
        this.roleId = roleId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountDetailId() {
        return accountDetailId;
    }

    public void setAccountDetailId(int accountDetailId) {
        this.accountDetailId = accountDetailId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", email=" + email + ", password=" + password + ", accountDetailId=" + accountDetailId + ", roleId=" + roleId + ", status=" + status + ", createDate=" + createDate + '}';
    }

    public String getFmDate() {
        String[] str = this.createDate.split("-");
        return str[2] + "-" + str[1] + "-" + str[0];
    }
}
