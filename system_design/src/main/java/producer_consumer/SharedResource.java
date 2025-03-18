package producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> resourceQueue;
    private final int bufferSize;

    public synchronized void produce(int i) throws InterruptedException {
        // Always use while instead of if when using wait() to avoid unpredictable race conditions.
        while(resourceQueue.size() == bufferSize) {
            // we have to wait
            System.out.println("Producer thread is waiting");
            wait();
        }

        resourceQueue.add(i);
        System.out.println("Produced: " + i);
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        // Always use while instead of if when using wait() to avoid unpredictable race conditions.
        while(resourceQueue.isEmpty()) {
            // we have to wait
            System.out.println("Consumer thread is waiting");
            wait();
        }

        int i = resourceQueue.poll();
        System.out.println("Consumed: " + i);
        notifyAll();
    }


    public SharedResource(int size) {
        this.bufferSize = size;
        this.resourceQueue = new LinkedList<>();
    }
}
