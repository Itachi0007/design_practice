package org.abstractFactory;

public class Laptop implements Computer {
    private int HDD;
    private int RAM;

    public Laptop(int HDD, int RAM) {
        this.HDD = HDD;
        this.RAM = RAM;
    }

    @Override
    public void getDetails() {
        System.out.println("Laptop has " + RAM +"GB RAM and "+ HDD + "GB HDD");

    }
}
