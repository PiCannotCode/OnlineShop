/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author SANG
 */
public class OrderDetail {
    private int id;
    private int orderId;
    private int productId;
    private String productName;
    private int productQuantity;
    private double productPrice;

    public OrderDetail() {
    }
   
    public OrderDetail(int id, int orderId, int productId, String productName, int productQuantity, double productPrice) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public OrderDetail(int orderId, int productId, String productName, int productQuantity, double productPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", productName=" + productName + ", productQuantity=" + productQuantity + ", productPrice=" + productPrice + '}';
    }
}
