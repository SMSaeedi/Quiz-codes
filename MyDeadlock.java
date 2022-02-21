package com.example.demo.deadLock;

public class MyDeadlock {

    private String str1 = "Java ";
    private String str2 = "Python ";

    Thread trd1 = new Thread("Thread 1") {
        public void run() {
            synchronized (str1) {
                synchronized (str2) {
                    System.out.println(str1 + str2);
                }
            }
        }
    };

    Thread trd2 = new Thread("Thread 2") {
        public void run() {
            synchronized (str2) {
                synchronized (str1) {
                    System.out.println(str2 + str1);
                }
            }
        }
    };

    public static void main(String a[]) {
        MyDeadlock mdl = new MyDeadlock();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}