package com.pluralsight.objects;

import java.util.ArrayList;
import java.util.List;

public class Order
{
    private List<Sandwich> sandwiches;
    private List<Drinks> drinks;
    private List<Chips> chips;

    public Order(){
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public void addDrink(Drinks drink) {
        drinks.add(drink);
    }

    public void addChip(Chips chip) {
        chips.add(chip);
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public List<Drinks> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drinks> drinks) {
        this.drinks = drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public void setChips(List<Chips> chips) {
        this.chips = chips;
    }
}
