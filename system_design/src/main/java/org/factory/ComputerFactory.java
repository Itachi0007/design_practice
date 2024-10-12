package org.factory;

// We can keep Factory class Singleton
// or we can keep the method that returns the subclass as static

public class ComputerFactory {
    public static Computer getInstance(Types type, int RAM, int HDD){
        if(type.equals(Types.PC)) {
            return new PC(RAM, HDD);
        } else if(type.equals(Types.LAPTOP)) {
            return new Laptop(RAM, HDD);
        }

        return null;
    }
}
