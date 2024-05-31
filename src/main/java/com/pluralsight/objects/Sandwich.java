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
        regularToppings.put("lettuce", 0.0);
        regularToppings.put("peppers", 0.0);
        regularToppings.put("onions", 0.0);
        regularToppings.put("tomatoes", 0.0);
        regularToppings.put("jalapenos", 0.0);
        regularToppings.put("cucumbers", 0.0);
        regularToppings.put("pickles", 0.0);
        regularToppings.put("guacamole", 0.0);
        regularToppings.put("mushrooms", 0.0);

        sauces.put("mayo", 0.0);
        sauces.put("mustard", 0.0);
        sauces.put("ketchup", 0.0);
        sauces.put("ranch", 0.0);
        sauces.put("thousand islands", 0.0);
        sauces.put("vinaigrette", 0.0);

        sides.put("au jus", 0.0);
        sides.put("sauce", 0.0);
    }

    private static void initPremiumToppings(int size)
    {
        switch (size)
        {
            case 4:
                meatToppings.put("steak", 1.00);
                meatToppings.put("ham", 1.00);
                meatToppings.put("salami", 1.00);
                meatToppings.put("roast beef", 1.00);
                meatToppings.put("chicken", 1.00);
                meatToppings.put("bacon", 1.00);
                cheeseToppings.put("american", 1.00);
                cheeseToppings.put("provolone", 1.00);
                cheeseToppings.put("cheddar", 1.00);
                cheeseToppings.put("swiss", 1.00);
                cheeseToppings.put("parmesan", 1.00);
                cheeseToppings.put("mozzarella", 1.00);
                break;
            case 8:
                meatToppings.put("steak", 2.00);
                meatToppings.put("ham", 2.00);
                meatToppings.put("salami", 2.00);
                meatToppings.put("roast beef", 2.00);
                meatToppings.put("chicken", 2.00);
                meatToppings.put("bacon", 2.00);
                cheeseToppings.put("american", 2.00);
                cheeseToppings.put("provolone", 2.00);
                cheeseToppings.put("cheddar", 2.00);
                cheeseToppings.put("swiss", 2.00);
                cheeseToppings.put("parmesan", 2.00);
                cheeseToppings.put("mozzarella", 2.00);
                break;
            case 12:
                meatToppings.put("steak", 3.00);
                meatToppings.put("ham", 3.00);
                meatToppings.put("salami", 3.00);
                meatToppings.put("roast beef", 3.00);
                meatToppings.put("chicken", 3.00);
                meatToppings.put("bacon", 3.00);
                cheeseToppings.put("american", 3.00);
                cheeseToppings.put("provolone", 3.00);
                cheeseToppings.put("cheddar", 3.00);
                cheeseToppings.put("swiss", 3.00);
                cheeseToppings.put("parmesan", 3.00);
                cheeseToppings.put("mozzarella", 3.00);
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

    public void setSize(int size)
    {
        initSandwich(size);
        initPremiumToppings(size);
        this.size = size;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }
}
