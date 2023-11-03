package base.collection.table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumExercise {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> calculateMap = new HashMap<>();

        for(int index = 0; index < nums.length; index++){
            if(calculateMap.containsKey(nums[index]))
                return new int[]{calculateMap.get(nums[index]), index};
            calculateMap.put(target - nums[index], index);
        }

        return new int[]{};
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [0, 1]
            [1, 2]
            [0, 1]
            []
            [2, 3]
            [0, 1]
            []

        */

    }
}
