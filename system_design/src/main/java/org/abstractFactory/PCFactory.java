package org.abstractFactory;

public class PCFactory implements ComputerAbsFactory{
    private int HDD;
    private int RAM;

    public PCFactory(int HDD, int RAM) {
        this.HDD = HDD;
        this.RAM = RAM;
    }

    @Override
    public Computer getComputer() {
        return new PC(HDD, RAM);
    }
}
