package com.example.demo.calculate;

public class BinarySearchDay01 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(search(nums, 5));
        System.out.println(firstBadVersion(2126753390));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));
    }
    /**
     * 二分查找算法
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
           int mindle = left + (right - left)/2;
           if (target == nums[mindle]) {
              return mindle;
           } else if (nums[mindle] > target) {
             right = mindle -1;
           } else {
            left = mindle + 1;
           }
        }
        return -1;
    }
    
    /**
     * 你是产品经理，目前正在带领一个团队开发新的产品。
     * 不幸的是，你的产品的最新版本没有通过质量检测。
     * 由于每个版本都是基于之前的版本开发的，
     * 所以错误的版本之后的所有版本都是错的。
      假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
     实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     */
    public static int firstBadVersion(int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
           int mindle = left + (right - left)/2;
           boolean badVersion = isBadVersion(mindle +1 );
           if (badVersion) {
               right = mindle;
           } else {
               left = mindle;
               if (right -left < 5) {
                   break;
                }
           }
        }
        for (int i = left; i <= right; i++) {
            if (isBadVersion(i + 1)) {
                return i + 1;
            }
        }
        return 1;
    }
    
   public static boolean isBadVersion(int n) {
       return n >= 1702766719;
   } 
   
   /**
    * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。
    * @param nums
    * @param target
    * @return
    */
   public static int searchInsert(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;
       while (left <= right) {
          int mindle = left + (right - left)/2;
          if (target == nums[mindle]) {
             return mindle;
          } else if (nums[mindle] > target) {
            right = mindle -1;
          } else {
           left = mindle + 1;
          }
       }
       return left;
   }
}
