package com.xiaoyu;

import org.junit.Test;

public class TestString {
    @Test
    public void test1(){
        new String().concat("a");

        new StringBuffer().append("b");

        char[] cs = {'a', 'b'};
        new String(cs);

        StringBuffer s = new StringBuffer("Bob");
        s.deleteCharAt(0);
        System.out.println(s);


        String s1 = "toto".replace('t', 's');
//        s1.replace('t', 's');
        System.out.println(s1);


    }
}
