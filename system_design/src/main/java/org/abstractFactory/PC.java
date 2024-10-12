package org.abstractFactory;

public class PC implements Computer {
    private int HDD;
    private int RAM;

    public PC(int HDD, int RAM) {
        this.HDD = HDD;
        this.RAM = RAM;
    }

    @Override
    public void getDetails() {
        System.out.println("PC has " + RAM +"GB RAM and "+ HDD + "GB HDD");
    }
}
