package org.perscholas.terminalgame;

public class Slot<T extends Product> {
    private T product;
    private int quantity;

    public Slot(T product, int quantity) throws IllegalArgumentException {
        if (product == null || quantity < 0) {
            throw new IllegalArgumentException("Order something bro..");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) throws IllegalArgumentException {
        if (product == null) {
            throw new IllegalArgumentException("No product specified smh..");
        }
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws IllegalArgumentException {
        if (quantity < 0) {
            throw new IllegalArgumentException("No quantity specified smh..");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
