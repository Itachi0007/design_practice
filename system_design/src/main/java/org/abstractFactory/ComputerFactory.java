package org.abstractFactory;

public class ComputerFactory {
    public static Computer getComputer(ComputerAbsFactory subFactory) {
        // Whatever sub-factory we pass to the super-factory
        // computer is created using that sub-factory's object
        return subFactory.getComputer();
    }
}
