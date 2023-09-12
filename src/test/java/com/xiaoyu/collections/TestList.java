package com.xiaoyu.collections;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class TestList {
    ArrayList<Integer> arrayList = new ArrayList<>();

    ArrayList<Integer> arrayList2 = new ArrayList<>(arrayList);


    public void test(){
        List<Integer> collect = arrayList.stream().toList();
    }

    public void test2() {
        for (Integer integer : arrayList) {

        }

        arrayList.forEach(System.out::println);

        arrayList.stream().forEach(System.out::println);
    }

    @Test
    public void test3(){
        new LinkedList<Object>().get(0);
    }
}
