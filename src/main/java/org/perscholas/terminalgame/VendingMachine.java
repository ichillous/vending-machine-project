package org.perscholas.terminalgame;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    Date timestamp = new Date();

    private Map<String, Slot<? extends Product>> slots;
    public VendingMachine() {
        this.slots = new HashMap<>();
    }
    public VendingMachine(Map<String, Slot<? extends Product>> slots) {
        this.slots = slots;
    }

    public void addProduct(String code, Slot<?> slot) throws IllegalArgumentException {
        if (code == null || code.isEmpty() ) {
            throw new IllegalArgumentException("code cannot be null or empty");
        }else if(slot == null) {
            throw new IllegalArgumentException("slot cannot be null");
        }
        slots.put(code, slot);
    }

    public Product dispenseProduct(String code) throws IOException {
        String name = slots.get(code).getProduct().getName();
        double price = slots.get(code).getProduct().getPrice();
        if (code == null || code.isEmpty() ) {
            throw new IllegalArgumentException("code cannot be null or empty");
        }
        if (slots.containsKey(code)) { // if code exists ⬇️
            if(slots.get(code).getQuantity() > 0){ // if greater than 0 then ->
                slots.get(code).setQuantity(slots.get(code).getQuantity() - 1); // decrement
                return slots.get(code).getProduct();
            } else {
                System.out.println("Product not available");
                sendVendorNotification(name);
            }
        }
        try {
            printReceipt(name, price);// Call
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void displayProducts(){
         slots.forEach((key, value) ->  System.out.println(key + " : " + value));
    }

    // UPDATE: MUST use BufferedWriter AND FileWriter to write a file called receipt.txt
    // NAME, PRICE, TIMESTAMP <- MUST BE INCLUDED
    // printReceipt METHOD ⬇️
    public void printReceipt(String name, double price) throws IOException {
        Date timestamp = this.timestamp;
        String fileName = timestamp + "_" + name + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Product name :\t " + name + "\n");
            writer.write("Product price :\t " + price + "\n");
            writer.write("Product timestamp :\t " + timestamp + "\n");
        } catch (IOException e ) {
            System.out.println("Error printing receipt" + e.getMessage());
        }
    }

    // WANTS:
    // - Massage: file name (Pepsi)
    public void sendVendorNotification(String productName) throws IOException {
        Date timestamp = this.timestamp;
        String fileName = "notification_" + productName + ".txt";//add timestamp
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("This product, " + productName +", is currently out of stock" + "\n");
            writer.write("Current Time : " + timestamp + "\n");
            writer.write("--------------------------------");
            writer.newLine();
        }
    }
    /*
    Update the VendingMachine class to include functionality to read products from a CSV file and add them to the vending machine.
    Each line in the CSV should contain
        - product code
        - type (Snack/Beverage)
        - name,
        - price
        - quantity.

    * */
    public void loadProductsFromCSV(String fileName) throws IOException {
        System.out.printf("%-10s %-15s %-20s %-10s %-10s%n", "Code", "Product Type", "Name", "Price", "Quantity");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String code = data[0];
                    String productType = data[1];
                    String productName = data[2];
                    double price = Double.parseDouble(data[3]);
                    int quantity = Integer.parseInt(data[4]);

                    //System.out.println("Code: " + code + "\nProduct Type: "+ productType + "\n Name: " + productName + "\n Price: " + price + "\n Quantity: " +quantity);


                    System.out.printf("%-10s %-15s %-20s %-10.2f %-10d%n", code, productType, productName, price, quantity);

                    Slot<Product> mySlot = new Slot<>(new Product(productName, price) , quantity);
                    slots.put(code, mySlot);// adds to our hashMap
                }

            }
        }
    }






    @Override
    public String toString() {
        return "VendingMachine{" +
                "slots=" + slots +
                '}';
    }
}
