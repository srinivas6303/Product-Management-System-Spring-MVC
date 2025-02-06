package com.example.PMS_SPRING_MVC;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String place;
    private int Warrenty;

    public Product() {
    }

    public Product(String name, String type, String place, int warrenty) {
        this.name = name;
        this.type = type;
        this.place = place;
        this.Warrenty = warrenty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getWarrenty() {
        return Warrenty;
    }

    public void setWarrenty(int warrenty) {
        Warrenty = warrenty;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", place='" + place + '\'' +
                ", Warrenty=" + Warrenty +
                '}';
    }

}
