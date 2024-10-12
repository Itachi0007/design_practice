package org.abstractFactory;

public class LaptopFactory implements ComputerAbsFactory {
    private int HDD;
    private int RAM;

    public LaptopFactory(int HDD, int RAM) {
        this.HDD = HDD;
        this.RAM = RAM;
    }

    @Override
    public Computer getComputer() {
        return new Laptop(HDD, RAM);
    }
}
