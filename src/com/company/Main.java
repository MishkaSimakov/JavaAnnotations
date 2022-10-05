package com.company;

public class Main {
    public static void main(String[] args) {
        User user = new User("test", 1, 123);
        Printer.print(user);
    }
}
