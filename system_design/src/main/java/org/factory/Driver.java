package org.factory;

public class Driver {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getInstance(Types.PC, 12, 512);
        Computer laptop = ComputerFactory.getInstance(Types.LAPTOP,8,256);

        laptop.getDetails();
        pc.getDetails();
    }
}
