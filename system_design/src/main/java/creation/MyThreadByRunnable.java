package creation;

public class MyThreadByRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread created with runnable was called using: " + Thread.currentThread().getName());
    }
}
