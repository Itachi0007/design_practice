package org.abstractFactory;

public class Driver {
    public static void main(String[] args) {
        // Here we are passing new object of sub-factory-type=PC and Computer factory
        // will use this new object's attributes and methods
        Computer pc = ComputerFactory.createComputer(new PCFactory(512,16));
        pc.getDetails();

        Computer laptop = ComputerFactory.createComputer(new LaptopFactory(256, 8));
        laptop.getDetails();
    }
}
