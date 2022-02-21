package com.example.demo.lambdaExpresson;

public class WithLambdaTest {

    public static void main(String[] args) {
        int width = 10;
        //without lambda, Drawable implementation using anonymous class
        TestInterface d = (int a) -> {
            System.out.println("Drawing " + width + " input parameter : " + a);
        };
        d.draw(1);
    }
}