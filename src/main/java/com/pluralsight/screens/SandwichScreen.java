package com.pluralsight.screens;

import com.pluralsight.objects.Order;
import com.pluralsight.objects.Receipt;
import com.pluralsight.objects.Sandwich;
import com.pluralsight.util.Inputs;

import java.util.ArrayList;

public class SandwichScreen
{
    private static double totalPrice = 0;
    public static void sandwichScreen(Order currentOrder, Sandwich sandwich)
    {
        System.out.println("""
                \n
                Customize your sandwich!
                
                [1] Choose bread size
                [2] Choose bread type
                [3] Choose meats (premium toppings)
                [4] Choose regular toppings
                [5] Choose sauces
                [6] choose toasted
                
                Type "Done" to finish editing Sandwich
                
                Enter choice:
                """);

        String userChoice = Inputs.getString();

        switch (userChoice) {
            case "1" ->
            {
                sandwich.setSize(breadSize());
                sandwichScreen(currentOrder, sandwich);
            }
            case "2" ->
            {
                sandwich.setBreadType(breadType());
                sandwichScreen(currentOrder, sandwich);
            }
            case "3" ->
            {
                premiumToppings(sandwich);
                sandwichScreen(currentOrder, sandwich);
            }
            case "4" ->
            {
                regularToppings(sandwich);
                sandwichScreen(currentOrder, sandwich);
            }
            case "5" ->
            {
                sauces(sandwich);
                sandwichScreen(currentOrder, sandwich);
            }
            case "6" ->
            {
                sandwich.setToasted(isToasted());
                sandwichScreen(currentOrder, sandwich);
            }
            case "Done", "done", "d", "D" -> {
                currentOrder.getSandwiches().add(sandwich);
                Functions.orderScreen(currentOrder);
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                sandwichScreen(currentOrder, sandwich);
            }
        }
    }

    public static int breadSize()
    {
        System.out.print("""
                What's the size of your sandwich?:
                __________________________________
                [1] 4"
                [2] 8"
                [3] 12"
                
                Choice :\s""");

        while(true)
        {
            int sizeOfSandwich = Inputs.getInt();
            switch (sizeOfSandwich)
            {
                case 4, 8, 12:
                    return sizeOfSandwich;
                default:
                    System.out.println("We don't have that size of bread, please try again: ");
                    System.out.println("Try: 4, 8 or 12");
                    System.out.println("Choice: ");
                    break;
            }
        }
    }

    public static String breadType()
    {
        System.out.print("""
                What type of bread would you like?:
                ___________________________________
                [1] White
                [2] Wheat
                [3] Rye
                [4] Wrap
                
                (ex write: "White" if bread choice is White)
                Choice:\s""");

        while(true)
        {
            String choiceOfBread = Inputs.getString();
            switch (choiceOfBread)
            {
                case "White", "Wheat","Rye", "Wrap":
                    return choiceOfBread;
                default:
                    System.out.println("We don't have that type of bread, please try again: ");
                    System.out.println("Choice: ");
                    break;
            }
        }
    }

    public static boolean isToasted()
    {
        System.out.print("""
                Would the bread be toasted or not?:
                ___________________________________
                [1] Yes
                [2] No
                
                Choice:\s""");

        boolean isToasted = false;
        boolean breakOutOfLoop3 = true;
        while(breakOutOfLoop3)
        {
            String choice = Inputs.getString();
            switch (choice) {
                case "Yes", "yes":
                    isToasted = true;
                    breakOutOfLoop3 = false;
                    break;
                case "No", "no":
                    breakOutOfLoop3 = false;
                    break;
                default:
                    System.out.print("""
                            Sorry we couldn't get that, please try again!
                            Choice:\s""");
                    break;
            }
        }
        return isToasted;
    }
    public static void premiumToppings(Sandwich sandwich)
    {
        ArrayList<String> premiumToppings = new ArrayList<>();
        ArrayList<String> meatPremiumToppings = new ArrayList<>();
        ArrayList<String> cheesePremiumToppings = new ArrayList<>();

        System.out.println("""
                       These are all our toppings:
                    ____________________________
                       Meats    |    Cheeses   |
                    ____________________________
                      Steak     |   American   |
                      Ham       |   Provolone  |
                      Salami    |   Cheddar    |
                     Roast Beef |   Swiss      |
                      Chicken   |              |
                      Bacon     |              |

                    Which extra topping would you like to add?:\s""");

        String pTopping = Inputs.getString();
        premiumToppings.add(pTopping);

        while (true)
        {
            System.out.println("\nWould you like extra toppings? (yes/no)");
            String choice2 = Inputs.getString();

            if (choice2.equalsIgnoreCase("yes") || choice2.equalsIgnoreCase("y"))
            {
                System.out.println("Extra 'Meat' or 'Cheese'? ");
                System.out.println("Choice: ");
                String meatOrCheese = Inputs.getString();

                if (meatOrCheese.equalsIgnoreCase("meat"))
                {
                    System.out.println("Enter extra meat toppings (type 'Done' to finish):");
                    while (true)
                    {
                        String input = Inputs.getString();
                        if (input.equalsIgnoreCase("done"))
                        {
                            break;
                        }
                        if (Sandwich.isValidTopping(input))
                        {
                            meatPremiumToppings.add(input);
                            premiumToppings.add(input);
                        }
                        else
                        {
                            System.out.println("Invalid Topping, Please enter a topping from the list!");
                        }
                    }

                    System.out.println("You entered:");

                    for (String input : meatPremiumToppings)
                    {
                        double price = sandwich.getPrice(input, true);
                        if (price != -1.00)
                        {
                            System.out.println(input + ": $" + price);
                            totalPrice += price;
                        }
                        else
                        {
                            System.out.println(input + ": Topping not found");
                        }
                    }
                }


                else if (meatOrCheese.equalsIgnoreCase("cheese"))
                {
                    System.out.println("Enter extra cheese (type 'Done' to finish):");
                    while (true)
                    {
                        String input = Inputs.getString();
                        if (input.equalsIgnoreCase("done"))
                        {
                            break;
                        }
                        if (Sandwich.isValidTopping(input))
                        {
                            cheesePremiumToppings.add(input);
                            premiumToppings.add(input);
                        }
                        else
                        {
                            System.out.println("Invalid Topping, Please enter a topping from the list!");
                        }
                    }
                    for (String input : cheesePremiumToppings)
                    {
                        double price = sandwich.getPrice(input, true);
                        if (price != -1.00)
                        {
                            System.out.println(input + ": $" + price);
                            totalPrice += price;
                        }
                        else
                        {
                            System.out.println(input + ": Topping not found");
                        }
                    }
                }
                sandwich.setPToppings(premiumToppings);

                System.out.println(sandwich.getPToppings());
                System.out.printf("The total price is: $ %.2f", totalPrice);

            }

            else if (choice2.equalsIgnoreCase("no") || choice2.equalsIgnoreCase("n"))
            {
                double totalPrice = 0.00;
                for (String input : premiumToppings)
                {
                    double price = sandwich.getPrice(input, true);
                    if (price != -1.0)
                    {
                        System.out.println(input + ": $" + price);
                        totalPrice += price;
                    }
                    else
                    {
                        System.out.println(input + ": Topping not found");
                    }
                }
                System.out.printf("The total price is: $ %.2f", totalPrice);
                break;
            }

            else
            {
                System.out.println("Sorry we couldn't get that, could you please try again?");
                System.out.println("Choice(Ex: Y/N :)");
            }
            double total = sandwich.getTotalPrice();
            total += totalPrice;
            sandwich.setTotalPrice(total);
        }
    }
    static ArrayList<String> regularToppings = new ArrayList<>();

    public static void regularToppings(Sandwich sandwich)
    {
                System.out.println("""
                        This are our regular toppings, free of charge:
                        ______________________________________________
                        Regular Toppings
                         - Lettuce
                         - Peppers
                         - Onions
                         - Tomatoes
                         - Jalapenos
                         - Cucumbers
                         - Pickles
                         - Guacamole
                         - Mushrooms
                         Enter values (type 'done' to finish):
                        """);

                while (true)
                {
                    String regularTopping = Inputs.getString();
                    if (regularTopping.equalsIgnoreCase("done"))
                    {
                        break;
                    }
                    if(Sandwich.isValidTopping(regularTopping))
                    {
                        regularToppings.add(regularTopping);
                    }
                    else {
                        System.out.println("Invalid Topping, Please enter a topping from the list!");
                    }
                    sandwich.setRToppings(regularToppings);
                }

                System.out.println("You entered: ");
                for (String input : regularToppings)
                {
                    System.out.println(input);
                }
    }

    public static void sauces(Sandwich sandwich)
    {
            ArrayList<String> saucesAndSides = new ArrayList<>();
            System.out.println("""
                    This are our Sauces and Sides, free of charge:
                    ______________________________________________
                    Sauces Toppings:
                     - Mayo
                     - Mustard
                     - Ketchup
                     - Ranch
                     - Thousand Islands
                     - Vinaigrette
                    Sides:
                     - au jus
                     - sauce
                     Enter values (type 'done' to finish):
                    """);

            while (true)
            {
                String regularTopping = Inputs.getString();
                if (regularTopping.equalsIgnoreCase("done"))
                {
                    break;
                }
                if(Sandwich.isValidTopping(regularTopping))
                {
                    saucesAndSides.add(regularTopping);
                    regularToppings.add(regularTopping);
                }
                else {
                    System.out.println("Invalid Topping, Please enter a topping from the list!");
                }
                sandwich.setRToppings(regularToppings);
            }

            System.out.println("You entered: ");
            for (String input : saucesAndSides)
            {
                System.out.println(input);
            }
    }
}
