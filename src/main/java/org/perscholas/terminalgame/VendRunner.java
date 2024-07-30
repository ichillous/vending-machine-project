package org.perscholas.terminalgame;

import java.io.IOException;

public class VendRunner {
    public static void main(String[] args) throws IOException {
        // Snack Bev and Slot
        Snack snack1 = new Snack("Noodles", 1.99, false);
        Beverage bev1 = new Beverage("Pepsi", 2.50, 18);

        System.out.println("-----Snack1-----");
        System.out.println(snack1.toString());
        System.out.println("------bev1-----");
        System.out.println(bev1.toString());
        // SLOTS
        Slot<Snack> slot1 = new Slot<>(snack1, 1);
        Slot<Beverage> slot2 = new Slot<>(bev1, 2);
        System.out.println("------slot1-----");
        System.out.println(slot1.toString());

        System.out.println("------slot2-----");
        System.out.println(slot2.toString());

        // VENDING MACHINE
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(snack1.getName(), slot1);
        vendingMachine.addProduct(bev1.getName(), slot2);
        System.out.println("\n------Vending Before Dispense-----");
        vendingMachine.displayProducts();
        System.out.println("\n------CSV-----");
        vendingMachine.loadProductsFromCSV("products.csv");
//        Product dispensedProduct1 = vendingMachine.dispenseProduct("Pepsi");
//        Product dispensedProduct2 = vendingMachine.dispenseProduct("Doritos");
//        Product dispensedProduct3 = vendingMachine.dispenseProduct("Doritos");
        System.out.println("\n------After Dispense-----");
        vendingMachine.displayProducts();

        // Error Handling Tests
        Snack snack2 = new Snack("M&Ms", 1.99, false); // ✅ Negative price
        Beverage bev2 = new Beverage("Pepsi", 2.50, 345); // ✅ Negative num
        Snack snack3 = new Snack("Hot Fries", 1.99, false); // ✅ Empty Name OR Numbers
        Slot<Snack> slot3 = new Slot<>(snack2, 1);
        Slot<Beverage> slot4 = new Slot<>(bev2, 2);
        Slot<Snack> slot5 = new Slot<>(snack3, 2);

//        vendingMachine.displayProducts();
        System.out.println("\n------CSV-----");
        vendingMachine.loadProductsFromCSV("products.csv");

        System.out.println("\n------display-----");
        vendingMachine.displayProducts();
    }
}
