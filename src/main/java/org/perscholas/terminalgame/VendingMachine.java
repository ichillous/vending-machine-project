package org.perscholas.terminalgame;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    /**/
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

    public Product dispenseProduct(String code) throws IllegalArgumentException {
        if (code == null || code.isEmpty() ) {
            throw new IllegalArgumentException("code cannot be null or empty");
        }
        if (slots.containsKey(code)) { // if code exists ⬇️
            if(slots.get(code).getQuantity() > 0){ // if greater than 0 then ->
                slots.get(code).setQuantity(slots.get(code).getQuantity() - 1); // decrement
                return slots.get(code).getProduct();
            } else {
                System.out.println("Product not available");
            }
        }
        return null;
    }

    public void displayProducts(){
        // should provide code and slot details
//        for ( Map.Entry<String, Slot<? extends Product>> entry : slots.entrySet()){
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        // lambda example:
        // ➡️ slots.forEach((key, value) -> System.out.println(key + ": " + value)); 🚀
         slots.forEach((key, value) ->  System.out.println(key + " : " + value));
        // Additional operations System.out.println("Slot: " + value); });
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "slots=" + slots +
                '}';
    }
}
