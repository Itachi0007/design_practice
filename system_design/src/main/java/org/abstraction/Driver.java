package org.abstraction;


public class Driver {
    public static void main(String[] args) {
        var mailService = new Mailer();
        // IT IS UNNECESSARY MAYBE TO HAVE CONNECT/DISCONNECT EXPOSED
        // mailService.connect();
        mailService.sendEmail();
    }
}
