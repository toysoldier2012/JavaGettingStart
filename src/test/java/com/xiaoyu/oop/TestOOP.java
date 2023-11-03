package com.xiaoyu.oop;

import com.xiaoyu.oop.AnInterface;
import com.xiaoyu.oop.ClasseFille;
import com.xiaoyu.oop.ClasseMere;
import org.junit.Test;

public class TestOOP {
    @Test
    public void test(){
        ClasseMere.classeMereStaticMethode();
        ClasseFille.classeMereStaticMethode();
    }

    @Test
    public void testInterface(){
        AnInterface.doSomething();

        ClasseFille classeFille = new ClasseFille();
        classeFille.testInterfaceDefaultMethod();
    }
}
