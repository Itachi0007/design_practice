package org.abstractFactory;

public class ComputerFactory {
    public static Computer createComputer(ComputerAbsFactory subFactory) {
        // Whatever sub-factory we pass under the umbrella of super-factory
        // computer is created using that sub-factory's object
        return subFactory.getComputer();
    }
}
