package com.knowwen;

public class MainTest {

    public static void main(String[] args) {
        testShort();
    }

    public static void testShort(){
        short s = 1;
        // s = s + 1;
        s += 1;
    }

    public static void testString(){
        String hello = "hello";
        System.out.println(hello.hashCode());
        hello += " World";
        System.out.println(hello.hashCode());
    }

}
