package com.example.demo.calculate;

public class DoublePointerDay03 {

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }
        int[] numbers = {2,7,11,15};
        int[] twoSum = twoSum(numbers, 9);
        System.out.println(twoSum[0]+ "-" + twoSum[1]);
        int[] numbers2 = {2,3,4};
        int[] twoSum2 = twoSum(numbers2, 6);
        System.out.println(twoSum2[0]+ "-" + twoSum2[1]);
        int[] numbers3 = {-1,0};
        int[] twoSum3 = twoSum(numbers3, -1);
        System.out.println(twoSum3[0]+ "-" + twoSum3[1]);
    }
    
    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
链接：https://leetcode-cn.com/problems/move-zeroes
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0, k = 1; i < nums.length -k; k++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j-1] = nums[j];
                    nums[j] = 0;
                }
            }else {
                i++;
                k--;
            }
        }
    }
    
    /**
     * 167. 两数之和 II - 输入有序数组
给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。

函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。

你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

 
示例 1：

输入：numbers = [2,7,11,15], target = 9
输出：[1,2]
解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
示例 2：

输入：numbers = [2,3,4], target = 6
输出：[1,3]
示例 3：

输入：numbers = [-1,0], target = -1
输出：[1,2]
     */
    
    public static int[] twoSum(int[] numbers, int target) {
         for (int i = 0, j = numbers.length -1; i <= j;) {
             int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i +1, j +1};
            }else if (sum > target) {
                j--;
            }else {
                i++;
            }
         }
         return null;
    }
}
