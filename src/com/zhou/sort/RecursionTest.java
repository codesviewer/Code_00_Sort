package com.zhou.sort;

public class RecursionTest {
	//用递归找一个数组中 最大的元素
	public static int getMax(int[] arr, int L, int R) {
		if(L == R) {
			return arr[L];
		}
		int mid = (L + R) / 2;
		int maxLeft = getMax(arr, L, mid);
		int maxRight = getMax(arr, mid+1, R);
		return Math.max(maxLeft, maxRight);
	}
	public static void main(String[] args) {
		int[] arr = {7,6,3,4};
		System.out.println(getMax(arr, 0, arr.length - 1) );
	}
 
} 
