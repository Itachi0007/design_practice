package monitor_locks;

public class Driver {
    public static void main(String[] args) {
        // We create an object of a class
        MyClass obj1 = new MyClass();

        // Lets create 3 different threads on the same obj1 to witness monitor locks
        Thread t1 = new Thread( () -> { obj1.task1(); } );
        Thread t2 = new Thread( () -> { obj1.task2(); } );
        Thread t3 = new Thread( () -> { obj1.task3(); } );

        t1.start();
        t2.start();
        t3.start();
    }
}
/*

Both are same but the compiler converted the lambda expression into an instance of Runnable.
Note that if any task() returned value : we cannot use lambda expression then

new Thread( () -> { obj1.task1(); } );
new Thread(new Runnable() {
    @Override
    public void run() {
        obj1.task1();
    }
});

 */