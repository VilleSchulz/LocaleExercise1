package org.example;

import java.text.MessageFormat;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ShoppingCart {
    static List<Double> shoppingList = new ArrayList<>();

     public double calculateTotalCost() {
        double totalCost = 0;

        for (Double itemPrice : shoppingList) {
            totalCost += itemPrice;
        }
        return totalCost;


    }

    public static void main(String[] args) {
         ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        Locale locale;
        ResourceBundle rb;
        System.out.println("Choose language:");
        System.out.println("1.Swedish");
        System.out.println("2.Japanese");
        System.out.println("3.Finnish");
        int choice = scanner.nextInt();
        switch (choice) {

            case 1:
                locale = new Locale("sv", "SE");
                break;
            case 2:
                locale = new Locale("ja", "JP");
                break;

            case 3:
                locale = new Locale("fi", "FI");
                break;
            default:
                System.out.println("Invalid choice, defaulting to English (US)");
               locale = new Locale("en", "US");


        }
        try {


            rb = ResourceBundle.getBundle("messages", locale);


        } catch (Exception e) {
            System.out.printf("Invalid selection");
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));


        }

        String totalQuantityMessage = rb.getString("totalQuantityMessage");
        String itemQuantityMessage = rb.getString("itemQuantityMessage");
        String itemPriceMessage = rb.getString("priceMessage");



        System.out.println(totalQuantityMessage);

        int totalQuantity = scanner.nextInt();
        for (int i = 0; i < totalQuantity; i++) {

            System.out.println(itemQuantityMessage);
            int itemQuantity = scanner.nextInt();
            System.out.println(itemPriceMessage);
            double itemPrice = scanner.nextDouble();
            shoppingList.add(itemQuantity*itemPrice);

        }
        double totalPrice = shoppingCart.calculateTotalCost();
        String totalmessage = MessageFormat.format(rb.getString("totalCostMessage"),String.format("%.2f",  totalPrice));
        System.out.println(totalmessage);




    }
}