/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author hanoon
 */
public class AccountAll {

    private int id;
    private String email;
    private String role;
    private String status;
    private String createDate;
    private String name;
    private String phone ;
    private boolean gender ;
    private String address;

    public AccountAll() {
    }

    public AccountAll(int id, String email, String role, String status, String createDate, String name, String phone, boolean gender, String address) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.status = status;
        this.createDate = createDate;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AccountAll{" + "id=" + id + ", email=" + email + ", role=" + role + ", status=" + status + ", createDate=" + createDate + ", name=" + name + ", phone=" + phone + ", gender=" + gender + ", address=" + address + '}';
    }
    
    
}
