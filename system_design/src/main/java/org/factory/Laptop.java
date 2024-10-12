package org.factory;

public class Laptop implements Computer{
    int RAM;
    int HDD;

    public Laptop(int RAM, int HDD) {
        this.RAM = RAM;
        this.HDD = HDD;
    }

    @Override
    public void getDetails() {
        System.out.println("Laptop has " + RAM +"GB RAM and "+ HDD + "GB HDD");
    }
}
