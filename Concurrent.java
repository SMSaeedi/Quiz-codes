package com.example.demo.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Concurrent {

    public static void main(String[] args) {
               Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }

    public static void main2(String[] args) {
        Runnable task = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                sleep(1000);
                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }

    public static void main3(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("How do you do? " + threadName);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Bye " + threadName);
        });
    }

    public static void main4(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    public static void main5(String[] args) {
        Callable<Integer> task = () -> {
            try {
                Integer returnVal = 152;
                TimeUnit.SECONDS.sleep(1);
                System.out.print("Callables can be submitted to executor services just like runnables." +
                        "But what about the callables result?" +
                        "Since submit() doesn't wait until the task completes," +
                        "the executor service cannot return the result of the callable directly." +
                        "Instead the executor returns a special result of type Future which can " +
                        "be used to retrieve the actual result at a later point in time.");
                return returnVal;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
    }

    public static void main6(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 200;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        Future<Integer> future = executor.submit(task);
        System.out.println("future done? " + future.isDone());

        //.get() --> blocks the current thread and waits until the callable completes before returning the actual result
        Integer result = future.get();

        System.out.println("future done? " + future.isDone());
        System.out.print("Callable result: " + result);
    }

    public static void main7(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 200;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        Future<Integer> future = executor.submit(task);
        System.out.println("future done? " + future.isDone());

        //Futures are tightly coupled to the underlying executor service.
        // Keep in mind that every non-terminated future will throw exceptions if you shutdown the executor:
        executor.shutdownNow();
        Integer result = future.get();

        System.out.println("future done? " + future.isDone());
        System.out.print("Callable result: " + result);
    }

    public static void main8(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        //You might already have guessed why this exception is thrown:
        //We specified a maximum wait time of one second but the callable actually needs two seconds before returning the result.
        Integer result = future.get(1, TimeUnit.SECONDS);
        System.out.println("result " + result);
    }

    public static void main9(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }).forEach(System.out::println);
    }

    public static void main10(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay + " ");
    }
}