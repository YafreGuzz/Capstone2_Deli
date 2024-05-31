package com.pluralsight.screens;

import com.pluralsight.objects.Order;
import com.pluralsight.objects.Receipt;
import com.pluralsight.objects.Sandwich;
import com.pluralsight.util.Inputs;

public class Functions
{
    public static void homeScreen()
    {
        System.out.println("""
                -----------------------------------
                | Welcome To Our DELI-cious Store |
                |What would you like to do today?:|
                -----------------------------------
                [1] New Order
                [0] Exit
                
                Choice:\s""");

        while (true)
        {
            int orderChoice = Inputs.getInt();

            switch (orderChoice)
            {
                case 1:
                    Order currentOrder = new Order();
                    orderScreen(currentOrder);
                    break;
                case 0:
                    System.out.println("Thanks for using our DELI-cious Sandwich App!");
                    System.exit(0);
                default:
                    System.out.println("""
                            Wrong input please try again!
                            -----------------------------""");
                    homeScreen();
                    break;
            }
        }
    }

    public static void orderScreen(Order currentOrder)
    {
        System.out.print("""
                Order Screen
                -------------
                [1] Add Sandwich
                [2] Add Drinks
                [3] Add Chips
                [4] Checkout
                [0] Cancel Order
                
                Choice:\s""");

        int orderChoice = Inputs.getInt();

        switch (orderChoice)
        {
            case 1:
                Sandwich sandwich = new Sandwich(0, "", false, 0.0);
                SandwichScreen.sandwichScreen(currentOrder, sandwich);
            break;
            case 2:
                DrinksScreen.drinksMenu(currentOrder);
                orderScreen(currentOrder);
            break;
            case 3:
                ChipsScreen.chipsScreen(currentOrder);
                orderScreen(currentOrder);
            break;
            case 4:
                Receipt.checkOut(currentOrder);
                homeScreen();
                break;
            case 0:
                Receipt.cancelOrder();
        }
    }

}