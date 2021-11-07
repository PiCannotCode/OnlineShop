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
public class Max {
    private int id ;


    public Max() {
    }

    public Max(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Max{" + "id=" + id + '}';
    }



}
