package com.example.demo.lambdaExpresson;

public class WithoutLambdaTest {

    public void run() {
        System.out.println("thread running");
    }

    public static void main( String[] args ){
        Thread t = new Thread(String.valueOf(new WithoutLambdaTest()));
        t.start();
    }
}