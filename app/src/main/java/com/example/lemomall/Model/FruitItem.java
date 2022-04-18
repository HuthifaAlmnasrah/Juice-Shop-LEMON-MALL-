package com.example.lemomall.Model;

public class FruitItem {
    private int img;
    private String name;
    private double price;

    public FruitItem(int img, String name, double price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
