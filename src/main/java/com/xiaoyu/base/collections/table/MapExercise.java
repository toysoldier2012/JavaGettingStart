package com.xiaoyu.base.collections.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercise {

    public static List<List<String>> groupAnagrams(String[] set){
        Map<Map<Character, Integer>, List<String>> res = new HashMap<>();

        for(String s : set){
            Map<Character, Integer> count = new HashMap<>();

            for(char c : s.toCharArray()){
                count.put(c, count.getOrDefault(c, 0) + 1);
            }


            List<String> strings = res.getOrDefault(count, new ArrayList<>());
            strings.add(s);
            res.put(count, strings);
        }



        return res.values().stream().toList();
    }


    public static void main(String[] args) {
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

        /*
            EXPECTED OUTPUT:
            ----------------
            1st set:
            [[eat, tea, ate], [tan, nat], [bat]]

            2nd set:
            [[abc, cba, bac], [foo], [bar]]

            3rd set:
            [[listen, silent], [triangle, integral], [garden, ranged]]

        */

    }
}

