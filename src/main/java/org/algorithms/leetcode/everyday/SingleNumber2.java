package org.algorithms.leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @class: SingleNumber2
 * @author: Lance Mone
 * @date: 2021/4/30 14:48
 * @description: 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */

public class SingleNumber2 {

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i <= nums.length){
            if (i+1<nums.length && i+2<nums.length) {
                if (nums[i] != nums[i+1] && nums[i] !=nums[i+2] && nums[i+1]==nums[i+2]) {
                    return nums[i];
                }
                if (nums[i] != nums[i+1] && nums[i+1] !=nums[i+2] && nums[i]==nums[i+2]) {
                    return nums[i+1];
                }
                if (nums[i] == nums[i+1] && nums[i] !=nums[i+2] && nums[i+1]!=nums[i+2]) {
                    return nums[i+2];
                }
                i +=3;
            }else {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args){
//        int[] nums = new int[]{0,1,0,1,0,1,99};
//        System.out.println(singleNumber(nums));
        System.out.println(Integer.toBinaryString(7));
    }
}
