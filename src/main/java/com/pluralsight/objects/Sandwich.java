package com.pluralsight.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sandwich
{
    protected int size;
    protected String breadType;
    protected boolean isToasted;
    private double totalPrice;
    private ArrayList<String> RToppings;
    private ArrayList<String> PToppings;

    private static final Map<String, Double> regularToppings = new HashMap<>();
    private static final Map<String, Double> premiumToppings = new HashMap<>();
    private static final Map<String, Double> meatToppings = new HashMap<>();
    private static final Map<String, Double> cheeseToppings = new HashMap<>();
    private static final Map<String, Double> sauces = new HashMap<>();
    private static final Map<String, Double> sides = new HashMap<>();

    {
        initRegularToppings();
    }

    public Sandwich(int size, String breadType, boolean isToasted, double totalPrice)
    {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.totalPrice = totalPrice;
        this.RToppings = new ArrayList<>();
        this.PToppings = new ArrayList<>();
    }

    private void initSandwich(int size)
    {
        switch (size)
        {
            case 4 -> totalPrice += 5.50;
            case 8 -> totalPrice += 7.00;
            case 12 -> totalPrice += 8.50;
        }
    }

    private static void initRegularToppings()
    {
        regularToppings.put("Lettuce", 0.0);
        regularToppings.put("Peppers", 0.0);
        regularToppings.put("Onions", 0.0);
        regularToppings.put("Tomatoes", 0.0);
        regularToppings.put("Jalapenos", 0.0);
        regularToppings.put("Cucumbers", 0.0);
        regularToppings.put("Pickles", 0.0);
        regularToppings.put("Guacamole", 0.0);
        regularToppings.put("Mushrooms", 0.0);

        sauces.put("Mayo", 0.0);
        sauces.put("Mustard", 0.0);
        sauces.put("Ketchup", 0.0);
        sauces.put("Ranch", 0.0);
        sauces.put("Thousand Islands", 0.0);
        sauces.put("Vinaigrette", 0.0);

        sides.put("au jus", 0.0);
        sides.put("sauce", 0.0);
    }

    private static void initPremiumToppings(int size)
    {
        switch (size)
        {
            case 4:
                meatToppings.put("Steak", 1.00);
                meatToppings.put("Ham", 1.00);
                meatToppings.put("Salami", 1.00);
                meatToppings.put("Roast Beef", 1.00);
                meatToppings.put("Chicken", 1.00);
                meatToppings.put("Bacon", 1.00);
                cheeseToppings.put("American", 1.00);
                cheeseToppings.put("Provolone", 1.00);
                cheeseToppings.put("Cheddar", 1.00);
                cheeseToppings.put("Swiss", 1.00);
                break;
            case 8:
                meatToppings.put("Steak", 2.00);
                meatToppings.put("Ham", 2.00);
                meatToppings.put("Salami", 2.00);
                meatToppings.put("Roast Beef", 2.00);
                meatToppings.put("Chicken", 2.00);
                meatToppings.put("Bacon", 2.00);
                cheeseToppings.put("American", 2.00);
                cheeseToppings.put("Provolone", 2.00);
                cheeseToppings.put("Cheddar", 2.00);
                cheeseToppings.put("Swiss", 2.00);
                break;
            case 12:
                meatToppings.put("Steak", 3.00);
                meatToppings.put("Ham", 3.00);
                meatToppings.put("Salami", 3.00);
                meatToppings.put("Roast Beef", 3.00);
                meatToppings.put("Chicken", 3.00);
                meatToppings.put("Bacon", 3.00);
                cheeseToppings.put("American", 3.00);
                cheeseToppings.put("Provolone", 3.00);
                cheeseToppings.put("Cheddar", 3.00);
                cheeseToppings.put("Swiss", 3.00);
                break;
        }
    }

    public int getSize()
    {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<String> getRToppings() {
        return RToppings;
    }

    public void setRToppings(ArrayList<String> RToppings) {
        this.RToppings = RToppings;
    }

    public ArrayList<String> getPToppings() {
        return PToppings;
    }

    public void setPToppings(ArrayList<String> PToppings) {
        this.PToppings = PToppings;
    }

    public double getPrice(String topping, boolean isExtra) {
        if (regularToppings.containsKey(topping))
        {
            return regularToppings.get(topping);
        }
        else if (meatToppings.containsKey(topping))
        {
            return isExtra ? getExtraPrice(topping, "Meat") : meatToppings.get(topping);
        }
        else if (cheeseToppings.containsKey(topping))
        {
            return isExtra ? getExtraPrice(topping, "Cheese") : cheeseToppings.get(topping);
        }
        else
        {
            return -1.0;
        }
    }

    private double getExtraPrice(String topping, String type) {
        switch (size) {
            case 4:
                return type.equals("Meat") ? 0.50 : 0.30;
            case 8:
                return type.equals("Meat") ? 1.00 : 0.60;
            case 12:
                return type.equals("Meat") ? 1.50 : 0.90;
            default:
                return 0.0;
        }
    }

    public static boolean isValidTopping(String topping)
    {
        return regularToppings.containsKey(topping) || meatToppings.containsKey(topping) || cheeseToppings.containsKey(topping) || sauces.containsKey(topping) || sides.containsKey(topping);
    }

    public static Map<String, Double> getSauces() {
        return sauces;
    }

    public static Map<String, Double> getSides() {
        return sides;
    }

    public void setSize(int size)
    {
        initSandwich(size);
        initPremiumToppings(size);
        this.size = size;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }
}
