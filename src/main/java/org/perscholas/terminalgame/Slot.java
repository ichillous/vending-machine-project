package org.perscholas.terminalgame;

public class Slot<T extends Product> {
    private T product;
    private int quantity;

    public Slot(T product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
