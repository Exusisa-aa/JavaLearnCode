package com.self.more.Calculator;

public class TwoOfQuarterToFindExample {
    //给你一个按照非递减排序的整数数列nums，和一个目标值target，请你找出给定目标值在数组中的开始位置和结束位置
    //如果数组中不存在目标值target，返回[-1,-1]
    //确保使用的是二分查找法
    public static void main(String[] args) {
        int[] nums = {2,5,6,7,7,7,7,9,10};
        int target = 7;
        int leftIndex = leftIndex(nums,target);
        int rightIndex = rightIndex(nums,target);
        System.out.println("[" + leftIndex + "," + rightIndex + "]");
    }

    public static int leftIndex(int[] nums, int target) {
        int rs = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(target > nums[mid]) {
                start = mid + 1;
            }else if(target < nums[mid]) {
                end = mid - 1;
            }else {
                rs = mid;
                end = mid - 1;
            }
        }
        return rs;
    }

    public static int rightIndex(int[] nums, int target) {
        int rs = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(target > nums[mid]) {
                start = mid + 1;
            }else if(target < nums[mid]) {
                end = mid - 1;
            }else {
                rs = mid;
                start = mid + 1;
            }
        }
        return rs;
    }
}
