package com.example.demo.datastructure;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayDay02 {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] twoSum = twoSum(nums, 9);
        System.out.println(twoSum[0] + "-" + twoSum[1]);
        int[] nums2 = {3,2,4};
        int[] twoSum2 = twoSum(nums2, 6);
        System.out.println(twoSum2[0] + "-" + twoSum2[1]);
        int[] nums3 = {3,3};
        int[] twoSum3 = twoSum(nums3, 6);
        System.out.println(twoSum3[0] + "-" + twoSum3[1]);
        int[] nums5 = {1,2,3,0,0,0}; int m = 3; int[] nums6 = {2,5,6}; int n = 3;
        merge2(nums5, m, nums6, n);
        for (int i : nums5) {
            System.out.println(i);
        }
        
    }
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

 

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]

链接：https://leetcode-cn.com/problems/two-sum
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0, j = nums.length -1; i < j ;) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[] {i,j};
            } else {
                if (i == j-1) {
                    i =0;
                    j--;
                }else {
                    i++;
                }
            }
        }
        return null;
    }
    
    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

 

示例 1：

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
示例 2：

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]

链接：https://leetcode-cn.com/problems/merge-sorted-array
     */
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] array = IntStream.concat(Arrays.stream(nums1, 0, m), Arrays.stream(nums2, 0, n))
        .sorted().toArray();
        for (int i = 0; i < array.length; i++) {
            nums1[i] = array[i];
        }
    }
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
       System.arraycopy(nums2, 0, nums1, m, n);
       Arrays.sort(nums1);
    }
}
