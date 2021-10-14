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
public class Product {
    
    private int id;
    private String name;
    private int category_id;
    private float price;
    private String description;
    private int quantity;
    private int status;
    private String image;
    private String note;

    public Product() {
    }

    public Product(int id, String name, int category_id, float price, String description, int quantity, int status, String image, String note) {
        this.id = id;
        this.name = name;
        this.category_id = category_id;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.status = status;
        this.image = image;
        this.note = note;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        if (status == 1) {
            return "Còn hàng";
        }else{
            return "Hết hàng";
        }
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", category_id=" + category_id + ", price=" + price + ", description=" + description + ", quantity=" + quantity + ", status=" + status + ", image=" + image + ", note=" + note + '}';
    }
}
