package producer_consumer;

public class Driver {
    public static void main(String[] args) {
        SharedResource sharedResourceObj = new SharedResource(3);

        Thread producerThread = new Thread(() -> {
            for(int i=0;i<5;i++) {
                try {
                    sharedResourceObj.produce(i);
                    Thread.sleep(10); // Gives time for consumer to start running
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // prints main before starting producer thread
        System.out.println(Thread.currentThread().getName());

        Thread consumerThread = new Thread(() -> {
            for(int i=0;i<5;i++) {
                try {
                    sharedResourceObj.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        consumerThread.start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        producerThread.start();
    }
}
/*
The JVM does not guarantee that Thread-0 (producer) will execute before Thread-1 (consumer).
The OS thread scheduler decides which thread runs first.
 */
