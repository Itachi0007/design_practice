package monitor_locks;

public class MyClass {
    public synchronized void task1() {
        try {
            System.out.println("Task-1 being executed by: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void task2() {
        System.out.println("Inside Task-2 but before synchronized: " + Thread.currentThread().getName());
        synchronized (this) {
            System.out.println("Printing from inside of synchronized of Task-2");
        }
    }

    public void task3() {
        System.out.println("Task-3 is being executed by thread: " + Thread.currentThread().getName());
    }
}
