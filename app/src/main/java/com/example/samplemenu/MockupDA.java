package com.example.samplemenu;

import java.util.ArrayList;
import java.util.List;

public class MockupDA {

    List<Drink> drinks;

    public MockupDA(){
        drinks = new ArrayList<>();
        drinks.add(new Drink("Tea", 1.50, "hot drink"));
        drinks.add(new Drink("Ice Coffee", 2.00, "cold drink"));
        drinks.add(new Drink("Latte", 2.50, "hot drink"));
        drinks.add(new Drink("Smoothie", 3.00, "cold drink"));
        drinks.add(new Drink("Hot Chocolate", 2.00, "hot drink"));
        drinks.add(new Drink("Iced Lemon Tea", 1.75, "cold drink"));
        drinks.add(new Drink("Cappuccino", 2.75, "hot drink"));
        drinks.add(new Drink("Cold Brew Coffee", 3.50, "cold drink"));
        drinks.add(new Drink("Orange Juice", 2.25, "fruit juice"));
        drinks.add(new Drink("Mango Juice", 2.50, "fruit juice"));
        drinks.add(new Drink("Milk", 1.00, "dairy drink"));
        drinks.add(new Drink("Yogurt Drink (Ayran)", 2.00, "dairy drink"));
        drinks.add(new Drink("Lassi", 2.50, "dairy drink"));
        drinks.add(new Drink("Coconut Water", 3.00, "cold drink"));
        drinks.add(new Drink("Mint Lemonade", 2.75, "mocktail"));
        drinks.add(new Drink("Virgin Mojito", 3.00, "mocktail"));
        drinks.add(new Drink("Pineapple Juice", 2.50, "fruit juice"));
        drinks.add(new Drink("Banana Milkshake", 3.00, "dairy drink"));
        drinks.add(new Drink("Energy Drink (Red Bull)", 2.75, "energy drink"));
        drinks.add(new Drink("Ginger Lemonade", 2.50, "mocktail"));
    }

    public List<Drink> getAllDrinks(){
        return drinks;
    }

    public List<String> getDrinkTypes(){
        List<String> types = new ArrayList<>();
        types.add("All Drinks");
        for (Drink drink : drinks) {
            if (!types.contains(drink.getType())){
                types.add(drink.getType());
            }
        }
        return  types;
    }

    public List<Drink> getDrinkByType(String type){
        List<Drink> drinkList = new ArrayList<>();
        for (Drink drink : drinks) {
            if (drink.getType().equals(type)) {
                drinkList.add(drink);
            }
        }
        return drinkList;
    }

}
