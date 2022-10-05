package com.company;

public class User {
    @Printable
    private String name;

    @Printable
    private static Integer klass;

    public final int age;

    public User(String name, int klass, int age) {
        this.name = name;
        User.klass = klass;
        this.age = age;
    }
}