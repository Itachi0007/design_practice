package org.polymorphism;


import org.abstraction.Mailer;

public class Driver {
    public static void main(String[] args) {
        // The objects are interchange-able
        drawUIControl(new TextBox());
        drawUIControl(new CheckBox());
    }

    // SINCE THE "control" object of UIControl class can take any form - CheckBox or TextBox
    // WE CALL IT POLYMORPHISM
    public static void drawUIControl(UIControl control) {
        control.draw();
    }
}
