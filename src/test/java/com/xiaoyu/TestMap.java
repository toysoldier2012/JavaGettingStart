package com.xiaoyu;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TestMap {
    private Map<Integer, String> map = new HashMap<>();

    public void test1(){
        for (Map.Entry<Integer, String> e :
                map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        map.forEach((k, v) -> System.out.println(k + v));
    }

    // Test null dans hashmap
    @Test
    public void test2(){
        Map<Integer, String> map = new HashMap<>();

        map.put(null, "abc");
        map.put(null, "bcd");

        System.out.println(map);
    }

    /*
     * Collection to array with stream
     *
     * */
    @Test
    public void test3() {
        Map<Map<String, Integer>, List<String>> res = new HashMap<>();
        List<List<String>> resList = new ArrayList<>();

        resList = res.values().stream().toList();
    }
}
