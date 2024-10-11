package org.abstraction;

public class Mailer {
    public void sendEmail() {
        connect(Math.random());
        authenticate();
        disconnect();

        System.out.println("Mail sent successfully");
    }

//    THESE METHODS MUST BE PRIVATE TO HIDE ADDITIONAL COMPLEXITY
//    public void connect() {
//    }
//    public void authenticate() {
//    }
//    public void disconnect() {
//    }

    private void connect(double timelag) {
    }
    private void authenticate() {
    }
    private void disconnect() {
    }
}
