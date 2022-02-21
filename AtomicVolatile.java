package com.example.demo.AtomicVolatile;

public class AtomicVolatile {

    // declaring a count variable
    private int count;

    public void run() {
        // calculating the count
        for (int i = 1; i <= 5; i++) {

            try {
                Thread.sleep(i * 100);
                count++;
            } catch (InterruptedException
                    e) { // throwing an exception
                System.out.println(e);
            }
        }
    }

    // returning the count value
    public int getCount() {
        return this.count;
    }
}

// driver class
class GFG {

    // main method
    public static void main(String[] args)
            throws InterruptedException {

        // creating an thread object
        AtomicVolatile t = new AtomicVolatile();
        Thread t1 = new Thread((Runnable) t, "t1");

        // starting thread t1
        t1.start();
        Thread t2 = new Thread((Runnable) t, "t2");

        // starting thread t2
        t2.start();

        // calling join method on thread t1
        t1.join();

        // calling join method on thread t1
        t2.join();

        // displaying the count
        System.out.println("count=" + t.getCount());
    }
}