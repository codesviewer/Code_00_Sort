package com.zhou.sort;

public class Code_09_MaxGap {
	public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            //这个桶的最小最大与布尔值就要被改写
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        //寻找差值
        for (; i <= len; i++) {
            if (hasNum[i]) {
                 res = Math.max(res, mins[i] - lastMax);
                 lastMax = maxs[i];
            }
        }
        return res;
   }
   //怎么定位这个数它应该去哪个桶
   public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
   }
   public static void main(String[] args) {
        int[] arr = {1,0,4,9,5,3,2};//{3,6,9,0,2,4,1};
        System.out.println(maxGap(arr));
        System.out.println("=================================");
        printArray(arr);
   }
   private static void printArray(int[] arr) {
        if(arr == null) {
            return;
        }
        for(int i = 0; i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
   }
}
