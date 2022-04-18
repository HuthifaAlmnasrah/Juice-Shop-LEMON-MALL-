package com.example.lemomall.Model;

public class Order {
    private String oderId;
    private double price;

    public Order(String oderId, double price) {
        this.oderId = oderId;
        this.price = price;
    }

    public String getOderId() {
        return oderId;
    }

    public void setOderId(String oderId) {
        this.oderId = oderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
