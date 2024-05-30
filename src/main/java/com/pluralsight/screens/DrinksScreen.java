package com.pluralsight.screens;

import com.pluralsight.objects.Drinks;
import com.pluralsight.objects.Order;
import com.pluralsight.util.Inputs;

import java.util.List;

public class DrinksScreen
{
    static double totalPrice;

    public static void drinksMenu(Order currentOrder) {
        boolean breakOut;
        do {
            System.out.print("""
                    Which type of drink?:
                    [1] Sodas
                    [2] Juices
                    
                    Choice:\s""");

            int drinkChoice = Inputs.getInt();

            switch (drinkChoice) {
                case 1:
                    Drinks soda = sodasMenu();
                    currentOrder.addDrink(soda);
                    System.out.println(soda.getBrand());
                    break;
                case 2:
                    Drinks juice = juicesMenu();
                    currentOrder.addDrink(juice);
                    System.out.println(juice.getBrand());
                    break;
                default:
                    System.out.println("Sorry we couldn't get that, please try again!");
                    break;
            }
            System.out.println("Would you like to add another drink?");
            String choice2 = Inputs.getString();
            breakOut = choice2.equalsIgnoreCase("yes");
        }
        while (breakOut);
        choiceMenu(currentOrder.getDrinks());
    }

   public static void choiceMenu(List<Drinks> drinks)
    {
            System.out.println("You entered:");

            for (Drinks drink : drinks)
            {
                double price = drink.getPrice();
                if (price != -1.00)
                {
                    System.out.printf("%s : $ %.2f \n", drink.getBrand(), price);
                    totalPrice += price;
                }
                else
                {
                    System.out.println("Drink not found");
                }
            }
            System.out.println("The total price is: $" + totalPrice);
    }

    public static Drinks sodasMenu()
    {
        Drinks soda = new Drinks();
        System.out.println("""
                Select a Soda:
                [1] Coca Cola
                [2] Pepsi
                [3] Sprite
                [4] Mountain Dew
                [5] Dr.Pepper
                [6] Fanta
                [7] Root Beer
                """);
        int userInput = Inputs.getInt();

        if (Drinks.sodas.containsKey(userInput)) {
            soda.setBrand(Drinks.sodas.get(userInput));
            System.out.print("""
                    What size?
                    [1] Small
                    [2] Medium
                    [3] Large
    
                    Choice:\s""");

            String sizeChoice = Inputs.getString();
            String size = null;
            double price = 0;

            switch (sizeChoice) {
                case "1":
                    size = "Small";
                    price = 2.00;
                    break;
                case "2":
                    size = "Medium";
                    price = 2.50;
                    break;
                case "3":
                    size = "Large";
                    price = 3.00;
                    break;
                default:
                    System.out.println("Invalid size choice.");
                    break;
            }

            soda.setSize(size);
            soda.setPrice(price);
        } else {
            System.out.println("Sorry, that's not a valid choice, try again!");
        }
        return soda;
    }

    public static Drinks juicesMenu()
    {
        Drinks juice = new Drinks();
        System.out.println("""
                Select a Juice:
                [1] Orange
                [2] Apple
                [3] Grape
                [4] Cranberry
                [5] Pineapple
                [6] Lemonade
                [7] Pomegranate""");

        int userInput = Inputs.getInt();

        if (Drinks.juices.containsKey(userInput)) {
            juice.setBrand(Drinks.juices.get(userInput));
            switch (userInput) {
                case 1 -> juice.setPrice(2.75);
                case 2 -> juice.setPrice(2.00);
                case 3 -> juice.setPrice(1.80);
                case 4 -> juice.setPrice(2.45);
                case 5 -> juice.setPrice(3.00);
                case 6 -> juice.setPrice(1.00);
                case 7 -> juice.setPrice(4.50);
                default -> System.out.println("This was not a valid choice.");
            }
        }
        return juice;
    }
}
