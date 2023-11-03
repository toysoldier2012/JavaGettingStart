package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
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
}

