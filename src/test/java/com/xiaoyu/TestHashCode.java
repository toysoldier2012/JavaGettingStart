package com.xiaoyu;

import com.xiaoyu.pojo.Livre;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class TestHashCode {
    @Test
    public void test1(){
        HashSet<Livre> livres = new HashSet<>();

        Livre livre1 = new Livre(1, "Core java");
        Livre livre2 = new Livre(2, "Core java");

        System.out.println("Is the same livre: " + livre1.equals(livre2));
        System.out.println("with the same hashcode: " + (livre1.hashCode() == livre2.hashCode()));


        livres.add(livre1);
        livres.add(livre2);

        for (Livre l:
             livres) {
            System.out.println(l.toString());
        }
    }

    @Test
    public void test2(){
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Core java");
        map.put(2, "Core java");
        map.put(2, "Core java2");

        map.entrySet().forEach(System.out::println);
    }
}
