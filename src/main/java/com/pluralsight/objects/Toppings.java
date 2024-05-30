package com.pluralsight.objects;

import java.util.HashMap;
import java.util.Map;

public class Toppings
{
    private static Map<String, Double> regularToppings;
    private static Map<String, Double> premiumToppings;
    private static Map<String, Double> meatToppings;
    private static Map<String, Double> cheeseToppings;
    private static Map<String, Double> sauces;
    private static Map<String, Double> sides;

    private static boolean initialized = false;

public static void initialize(int size)
{
    if(!initialized)
    {
    regularToppings =new HashMap<>();
    premiumToppings =new HashMap<>();
    meatToppings =new HashMap<>();
    cheeseToppings =new HashMap<>();
    sauces =new HashMap<>();
    sides =new HashMap<>();

    initRegularToppings();
    initPremiumToppings(size);
    initialized = true;
    }
}

    public static void initRegularToppings()
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

    public static void initPremiumToppings(int size)
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

    public static double getPrice(String topping, int size, boolean isExtra)
    {
        if (regularToppings.containsKey(topping))
        {
            return regularToppings.get(topping);
        }
        else if (meatToppings.containsKey(topping))
        {
            return isExtra ? getExtraPrice(topping, size, "Meat") : meatToppings.get(topping);
        }
        else if (cheeseToppings.containsKey(topping))
        {
            return isExtra ? getExtraPrice(topping, size, "Cheese") : cheeseToppings.get(topping);
        }
        else
        {
            return -1.0;
        }
    }

    private static double getExtraPrice(String topping, int size, String type) {
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

    public static boolean isValidTopping(String topping, int size)
    {
        initialize(size);
        return regularToppings.containsKey(topping) || premiumToppings.containsKey(topping) || meatToppings.containsKey(topping) || cheeseToppings.containsKey(topping) || sauces.containsKey(topping) || sides.containsKey(topping);
    }

    public Map<String, Double> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(Map<String, Double> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public Map<String, Double> getPremiumToppings() {
        return premiumToppings;
    }

    public void setPremiumToppings(Map<String, Double> premiumToppings) {
        this.premiumToppings = premiumToppings;
    }

    public static Map<String, Double> getMeatToppings() {
        return meatToppings;
    }

    public static void setMeatToppings(Map<String, Double> meatToppings) {
        Toppings.meatToppings = meatToppings;
    }

    public static Map<String, Double> getCheeseToppings() {
        return cheeseToppings;
    }

    public static void setCheeseToppings(Map<String, Double> cheeseToppings) {
        Toppings.cheeseToppings = cheeseToppings;
    }

    public static Map<String, Double> getSauces() {
        return sauces;
    }

    public static void setSauces(Map<String, Double> sauces) {
        Toppings.sauces = sauces;
    }

    public static Map<String, Double> getSides() {
        return sides;
    }

    public static void setSides(Map<String, Double> sides) {
        Toppings.sides = sides;
    }
}