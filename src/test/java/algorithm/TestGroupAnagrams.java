package algorithm;

import org.junit.Test;

import static algorithm.GroupAnagrams.groupAnagrams;
import static junit.framework.TestCase.assertEquals;

public class TestGroupAnagrams {
    @Test
    public void should_return_group_anagrams(){
        assertEquals("[[eat, tea, ate], [tan, nat], [bat]]", groupAnagrams(new String[]{"eat", "tea", "tan", "ate",
                "nat", "bat"}));
        assertEquals("[[abc, cba, bac], [foo], [bar]]",new String[]{"abc", "cba", "bac", "foo", "bar"});
        assertEquals("[[listen, silent], [triangle, integral], [garden, ranged]]", groupAnagrams(new String[]{
                "listen", "silent", "triangle", "integral", "garden", "ranged"}));
    }

}
