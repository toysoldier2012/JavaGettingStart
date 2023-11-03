package com.xiaoyu.oop;

public class ClasseFille extends ClasseMere implements AnInterface, Comparable{
//        public static void classeMereStaticMethode(){
//            System.out.println("c'est le méthode fille");
//        }

    public void testInterfaceDefaultMethod(){
        AnInterface.super.aDefaultMethod();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
