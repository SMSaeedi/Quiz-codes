package com.example.demo.SOLID;

import org.apache.tomcat.jni.Error;

public class LiskovSubstitution {
    // The parent class should adapt for all the children, and when a class extend another class must not change the super class behaviour

    public static void main(String[] args) {
        Note n = new WritableNote(450);
        n.save("this is writable");

        Note n1 = new ReadonlyNote(550);
        n1.save("this is readable");
    }
}

class Note {
    int id;

    public Note(int id) {
        this.id = id;
    }

    public void save(String s) {
    }
}

class WritableNote extends Note {

    public WritableNote(int id) {
        super(id);
    }

    @Override
    public void save(String s) {
    }
}

class ReadonlyNote extends Note {

    public ReadonlyNote(int id) {
        super(id);
    }

    @Override
    public void save(String s) {
        try {
            throw new Exception("this is readable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}