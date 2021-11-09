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
public class Order {
    private int id;
    private int accountId;
    private String date;
    private double totalPrice;
    private String note;
    private int status;
    public String address;
    public String name;
    public String Phone;
    public String email;
    public float ship;
    public float Vat;
    public float totalPay;
    private int payments;
    public String reasonCancle;

    public Order() {
    }

    public Order(int id, int accountId, String date, double totalPrice, String note, int status, String address, String name, String Phone, String email, float ship, float Vat, float totalPay, int payments, String reasonCancle) {
        this.id = id;
        this.accountId = accountId;
        this.date = date;
        this.totalPrice = totalPrice;
        this.note = note;
        this.status = status;
        this.address = address;
        this.name = name;
        this.Phone = Phone;
        this.email = email;
        this.ship = ship;
        this.Vat = Vat;
        this.totalPay = totalPay;
        this.payments = payments;
        this.reasonCancle = reasonCancle;
    }

    public Order(int accountId, double totalPrice, String note, int status, String address, String name, String Phone, String email, float ship, float Vat, float totalPay, int payments, String reasonCancle) {
        this.accountId = accountId;
        this.totalPrice = totalPrice;
        this.note = note;
        this.status = status;
        this.address = address;
        this.name = name;
        this.Phone = Phone;
        this.email = email;
        this.ship = ship;
        this.Vat = Vat;
        this.totalPay = totalPay;
        this.payments = payments;
        this.reasonCancle = reasonCancle;
    }

    public Order(int accountId){
        this.accountId = accountId;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getShip() {
        return ship;
    }

    public void setShip(float ship) {
        this.ship = ship;
    }

    public float getVat() {
        return Vat;
    }

    public void setVat(float Vat) {
        this.Vat = Vat;
    }

    public float getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(float totalPay) {
        this.totalPay = totalPay;
    }

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }

    public String getReasonCancle() {
        return reasonCancle;
    }

    public void setReasonCancle(String reasonCancle) {
        this.reasonCancle = reasonCancle;
    }

    public String getFmDate(){
        String[] str = this.date.split("-");
        return str[2] + "-" + str[1] + "-" + str[0];
    }
    
}
