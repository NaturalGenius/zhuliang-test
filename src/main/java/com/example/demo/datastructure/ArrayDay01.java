package com.example.demo.datastructure;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayDay01 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate2(nums));
        int[] nums2 = {1,2,3,4};
        System.out.println(containsDuplicate(nums2));
        System.out.println(containsDuplicate2(nums2));
        int[] nums3 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums3));
    }
    
    //217. 存在重复元素
    /**
     * 给定一个整数数组，判断是否存在重复元素。

如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
输入: [1,2,3,1]
输出: true
输入: [1,2,3,4]
输出: false
     */
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
       return false;
    }
    public static boolean containsDuplicate2(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
    
    /**
     * 53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
输入：nums = [1]
输出：1
     */
    
    public static int maxSubArray(int[] nums) {
        int max =nums[0];
      //  for (int j = 0; j < nums.length; j++) {
            int sum =nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (sum > 0) {
                    sum += nums[i];
                }else   {
                    if (sum > max) {
                        max = sum;
                    }
                    sum = nums[i];
                }
            }
       // }
      return max;
    }
}
