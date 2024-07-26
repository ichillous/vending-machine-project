package org.perscholas.terminalgame;

public class Beverage extends Product {
    private double flOunces;

    public Beverage(String name, double price, double flOunces) throws IllegalArgumentException {
        super(name, price);
        if (flOunces < 0) {
            throw new IllegalArgumentException("flOunces must be a positive number");
        }

        this.flOunces = flOunces;
    }

    public double getFlOunces() {

        return flOunces;
    }

    public void setFlOunces(double flOunces) throws IllegalArgumentException{
        if (flOunces < 0){
            throw new IllegalArgumentException("flOunces must be a positive number");
        }
        this.flOunces = flOunces;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "flOunces=" + flOunces +
                "} " + super.toString();
    }
}
