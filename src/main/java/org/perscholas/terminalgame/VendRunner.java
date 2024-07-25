package org.perscholas.terminalgame;

public class VendRunner {
    public static void main(String[] args) {
        // Snack Bev and Slot
        Snack snack1 = new Snack("Doritos", 1.99, false);
        Beverage bev1 = new Beverage("Pepsi", 2.50, 16.8);
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
        Product dispensedProduct1 = vendingMachine.dispenseProduct("Pepsi");
        Product dispensedProduct2 = vendingMachine.dispenseProduct("Doritos");
        Product dispensedProduct3 = vendingMachine.dispenseProduct("Doritos");
        System.out.println("\n------After Dispense-----");
        vendingMachine.displayProducts();


    }
}