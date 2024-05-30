package com.pluralsight.objects;

import java.util.Map;

public class Drinks
{
    private String brand;
    private String size;
    private double price;

    public static Map<Integer, String> juices = Map.of(
            1, "Orange",
            2, "Apple",
            3, "Grape",
            4, "Cranberry",
            5, "Pineapple",
            6, "Lemonade",
            7, "Pomegranate"
    );
    public static Map<Integer, String> sodas = Map.of(
            1, "Coca Cola",
            2, "Pepsi",
            3, "Sprite",
            4, "Mountain Dew",
            5, "Dr.Pepper",
            6, "Fanta",
            7, "Root Beer"
    );

    public double getPrice()
    {
        return this.price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}