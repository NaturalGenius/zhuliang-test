package com.example.demo.calculate;

public class DoublePointerDay02 {

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] sortedSquares = sortedSquares(nums);
        for (int i : sortedSquares) {
            System.err.println(i);
        }
        int[]  nums2 = {-7,-3,2,3,11};
        int[] sortedSquares2 = sortedSquares(nums2);
        for (int i : sortedSquares2) {
            System.err.println(i);
        }
        int[]  nums3 = {1,2,3,4,5,6,7};
        rotate2(nums3, 3);
        for (int i = 0; i < nums3.length; i++) {
            System.out.println(nums3[i]);
        }
        int[]  nums4 = {1,2};
        rotate2(nums4, 3);
        for (int i = 0; i < nums4.length; i++) {
            System.out.println(nums4[i]);
        }
    }
    /**
     * 977. 有序数组的平方
     * 给你一个按 非递减顺序 排序的整数数组 nums，
     * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * 
     * 输入：nums = [-4,-1,0,3,10]
        输出：[0,1,9,16,100]
       解释：平方后，数组变为 [16,1,0,9,100]
       排序后，数组变为 [0,1,9,16,100]

      输入：nums = [-7,-3,2,3,11]
      输出：[4,9,9,49,121]
     */
    
    public static int[] sortedSquares(int[] nums) {
       for (int i = 0; i < nums.length; i++) {
         nums[i] =  nums[i] *  nums[i];
       }
       for (int i = 0; i < nums.length - 1; i++) {
          for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] > nums[j]) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
         }
       }
       return nums;
    }
    
    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

进阶：

尽可能想出更多的解决方案，至少有三种不
j


同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]


     */
    
    //时间换空间
    public static void rotate(int[] nums, int k) {
       for (int i = 0; i < k; i++) {
         int tmp = nums[0];
         for (int j = 1; j <= nums.length; j++) {
             int tmp1;
            if (j == nums.length) {
                tmp1 = nums[0];
                nums[0] = tmp;
            }else {
                tmp1 = nums[j];
                nums[j] = tmp;
            }
            tmp = tmp1;
         }
       }
    }
    
    //空间换时间
    public static void rotate2(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k = k%nums.length ;
        int[] tmpNums = new int[nums.length];
        for (int j = 0; j < nums.length ; j++) {
            if (j + k >= nums.length) {
                tmpNums[j + k - nums.length] = nums[j];
            }else {
                tmpNums[j + k] = nums[j];
            }
        }
        for (int i = 0; i < tmpNums.length; i++) {
            nums[i] = tmpNums[i];
        }
    }
}
