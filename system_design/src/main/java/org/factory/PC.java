package org.factory;

public class PC implements Computer{
    int RAM;
    int HDD;

    public PC(int RAM, int HDD) {
        this.RAM = RAM;
        this.HDD = HDD;
    }

    @Override
    public void getDetails() {
        System.out.println("PC has " + RAM +"GB RAM and "+ HDD + "GB HDD");
    }
}
