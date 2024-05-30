package com.pluralsight.screens;

import com.pluralsight.objects.Chips;
import com.pluralsight.objects.Order;
import com.pluralsight.util.Inputs;

import java.util.ArrayList;

public class ChipsScreen
{
    public static void chipsScreen(Order currentOrder)
    {
        while (true)
        {
            Chips chip = new Chips();
            System.out.println("""
                    Which Chips would you like to add?:
                    [1] Lays
                    [2] Doritos
                    [3] Pringles
                    [4] Cheetos
                    [5] Ruffles
                    [6] Tostitos
                    [7] Kettle Brand""");

            int choice = getUserChoice();
            if (choice == -1)
            {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            chip.setName(getChipName(choice));
            currentOrder.addChip(chip);

            System.out.println("Would you like to add another chip? (yes/no)");
            String addMore = Inputs.getString();
            if (!addMore.equalsIgnoreCase("yes")) break;
        }

        System.out.println("Selected Chips: ");
        for (Chips chip1 : currentOrder.getChips()) System.out.println(chip1.getName());

    }

    private static int getUserChoice()
    {
        try
        {
            int choice = Inputs.getInt();
            if (choice < 1 || choice > 7)
            {
                return -1;
            }
            return choice;
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
    }

    private static String getChipName(int choice)
    {
        return switch (choice)
        {
            case 1 -> "Lays";
            case 2 -> "Doritos";
            case 3 -> "Pringles";
            case 4 -> "Cheetos";
            case 5 -> "Ruffles";
            case 6 -> "Tostitos";
            case 7 -> "Kettle Brand";
            default -> "";
        };
    }
}

