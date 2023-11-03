package com.xiaoyu.oop;

public interface AnInterface {

    int a = 0;
    static void doSomething(){
        System.out.println("do something in an interface by a static method");
    }

    default void aDefaultMethod(){
        System.out.println("This is in default methode");
    }
}
