package org.example;

public class Medication {
    private final String name;
    private final double price;
    private final boolean availability;

    public Medication(String name, double price, boolean availability) {
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public String getName() {
    return name;
    }

    public double getPrice() {
    return price;
    }

    public boolean getAvailability() {
        return availability;
    }
}
