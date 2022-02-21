package com.example.demo.otherSamples;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[5];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);
            if (val == null) {
                map.put(nums[i], i);
            } else {
                arr[0] = val;
                arr[1] = i;
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int arr[] = {1, 2, 3,4,5};
        int target = 13;
        System.out.printf("result = " + twoSum.twoSum(arr, target));
    }
}