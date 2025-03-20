package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void calculateTotalCost() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.shoppingList.add(10.0);
        shoppingCart.shoppingList.add(20.0);
        shoppingCart.shoppingList.add(30.0);
        double totalCost = shoppingCart.calculateTotalCost();
        assertEquals(60.0, totalCost);


    }
}