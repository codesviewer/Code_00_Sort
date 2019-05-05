package com.zhou.sort;

public class Code_03_2_NixuDui {
	
	public static int mergeSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		return mergeSort(arr, 0, arr.length - 1);
	}

	private static int mergeSort(int[] arr, int l, int r) {
		if(l == r) {
			return 0;
		}
		int mid = l + ((r - l) >> 1);
		return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
	}

	private static int merge(int[] arr, int l, int mid, int r) {
		int p1 = l;
		int p2 = mid + 1;
		int i = 0;
		int[] help = new int[r - l + 1];
		int count = 0;
		while(p1 <= mid && p2 <= r) {
			count += arr[p1] < arr[p2] ? 0 : mid - p1 + 1;//左右双方 已经排好序
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while(p2 <= r) {
			help[i++] = arr[p2++];
		}
		for(i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		return count;
	}
	public static void main(String args[]) {
		int[] arr = {2,6,3,4,5,1}; 
		System.out.println(mergeSort(arr));
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
