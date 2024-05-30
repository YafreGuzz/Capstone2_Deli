package com.pluralsight.objects;

import com.pluralsight.screens.Functions;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt
{
    public static void checkOut(Order currentOrder)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String filePath = "src/main/resources/receipt_" + timestamp + ".txt";

        writeToFile(currentOrder, filePath);

        readFromFile(filePath);
    }

    private static void writeToFile(Order currentOrder, String filePath)
    {
        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter bufWriter = new BufferedWriter(fileWriter))
        {
            StringBuilder output = new StringBuilder();
            double totalPrice = 0;

            bufWriter.write("            Receipt          \n");
            bufWriter.write("=============================\n\n");

            if (!currentOrder.getSandwiches().isEmpty()) {
                output.append("\n          Sandwich          \n");
                output.append("=============================\n\n");
                for (Sandwich sandwich1 : currentOrder.getSandwiches()) {
                    output.append(String.format(
                            "Bread Type: %s%nSize: %d inches \nRegular Toppings:\n%s%n \nPremium Toppings:\n%s\n Total Price: $%.2f%n",
                            sandwich1.getBreadType(),
                            sandwich1.getSize(),
                            String.join("\n", sandwich1.getRToppings()),
                            String.join("\n", sandwich1.getPToppings()),
                            sandwich1.getTotalPrice()
                    ));
                    totalPrice += sandwich1.getTotalPrice();
                }
            }

            if (!currentOrder.getDrinks().isEmpty()) {
                output.append("\n           Drinks          \n");
                output.append("=============================\n\n");

                for (Drinks drink : currentOrder.getDrinks()) {
                    output.append(String.format("%s %s $%.2f\n", drink.getSize(), drink.getBrand(), drink.getPrice()));
                    totalPrice += drink.getPrice();
                }
            }



            if (!currentOrder.getChips().isEmpty()) {
                output.append("\n            Chips          \n");
                output.append("=============================\n\n");
                for (Chips chip : currentOrder.getChips()) {
                    output.append(String.format("%s $%.2f\n", chip.getName(), chip.getPrice()));
                    totalPrice += chip.getPrice();
                }
            }

            double tax = totalPrice * .07;
            double finalPrice = tax + totalPrice;

            output.append("=============================\n\n");
            output.append(String.format("Subtotal:             $%.2f\n", totalPrice));
            output.append(String.format("Tax (7%%):             $%.2f\n", tax));
            output.append(String.format("Total   :             $%.2f\n", finalPrice));

            bufWriter.write(output.toString());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static void readFromFile(String filePath)
    {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufReader = new BufferedReader(fileReader))
        {

            String line;
            while ((line = bufReader.readLine()) != null)
            {
                System.out.println(line);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void cancelOrder()
    {
        Functions.homeScreen();
    }
}