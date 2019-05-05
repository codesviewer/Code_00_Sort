package com.zhou.sort;

public class Code_06_HeapSort {

	public static void heapsort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			heapinsert(arr, i);
		}
		int heapsize = arr.length;
		swap(arr, 0, --heapsize);
		while(heapsize > 0) {
			heapify(arr, 0, heapsize);
			swap(arr, 0, --heapsize);
		}
	}
	
	private static void heapify(int[] arr, int index, int heapsize) {
		int left = index * 2 + 1;
		while(left < heapsize) {
			//这个largest是去寻找左孩子或者右孩子中较大的那个
			int largest = (left + 1 < heapsize && arr[left + 1] > arr[left] ? left + 1 : left);
			//继续比较这个左右孩子选出来的较大的那个和原来父节点比较，再选出较大的那个
		    largest = arr[largest] > arr[index] ? largest : index;
		    //如果还是最顶元素最大，那么直接退出循环
		    if(largest == index) {
		    	break;
		    }
		    //某个孩子比我大，那个孩子的位置就变成largest
		    swap(arr, largest, index);
		    index = largest;
		    left = index * 2 + 1;
		}
		
	}

	private static void heapinsert(int[] arr, int index) {
		while(arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {0,5,4,8,3,1,9,7};
		heapsort(arr);
		printarray(arr);
	}

	private static void printarray(int[] arr) {
		if(arr == null) {
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
