package com.yjx.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> maps = new HashMap();
        for(int i = 0;i<nums.length;i++){
            int sub = target - nums[i];
            if(maps.containsKey(sub)){
                return new int[]{maps.get(sub),i};
            }
            maps.put(nums[i],i);
        }
        throw new RuntimeException("not found");
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        log.info("{}",ints);
    }
}
