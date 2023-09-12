package com.xiaoyu.base.collections.set;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list){
        Set<Integer> hashSet = new HashSet<>(list);
        return new ArrayList<>(hashSet);
    }

    public static boolean hasUniqueChars(String s){
        char[] charArray = s.toCharArray();
        List<Character> charList = Arrays.asList(new Character[10]);
        Set<Character> charSet = new HashSet<>(charList);

        StringBuilder[] sbArray = new StringBuilder[5];

        return charSet.size() == s.length();


    }

    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
        List<Integer> newList = removeDuplicates(myList);
        System.out.println(newList);

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8, 9]

            (Order may be different as sets are unordered)
        */

    }
}
