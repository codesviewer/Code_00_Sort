package com.zhou.sort;

import java.util.Arrays;

public class Code_01_SelectionSort {
	public static void selectionSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		for(int i = 0;i < arr.length - 1; i++) {
			int minIndex = i;
			for(int j = i + 1;j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int testTime = 500000; //大样本测试 
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			selectionSort(arr1);
			comparator(arr2);
			
/*			System.out.println("arr1:");
			printArray(arr1);
			System.out.println("arr2:");
			printArray(arr2);*/
			
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		//判断我自己写的排序算法的方法是否真正的真确
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		
		System.out.println("生成随机数组为：");
		printArray(arr);
		
		selectionSort(arr);
		
		System.out.println("排序后的数组为：");
		printArray(arr);
	}
	
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}
	
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	//排序绝对正确的方法
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
