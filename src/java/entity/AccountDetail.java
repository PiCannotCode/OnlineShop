/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DucAnh
 */
public class AccountDetail {

    private int id;
    private String name;
    private String phone;
    private int gender;
    private String address;

    public AccountDetail() {
    }

    public AccountDetail(int id, String name, String phone, int gender, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
    }

    public AccountDetail(String name, String phone, int gender, String address) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AccountDetail{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", gender=" + gender + ", address=" + address + '}';
    }

}
