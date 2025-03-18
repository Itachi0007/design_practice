package creation;

public class MyThreadByExtending extends Thread{
    @Override
    public void run() {
        System.out.println("Thread created by extending Thread class was called: " + Thread.currentThread().getName());
    }
}
