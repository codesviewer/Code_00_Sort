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
			//���largest��ȥѰ�����ӻ����Һ����нϴ���Ǹ�
			int largest = (left + 1 < heapsize && arr[left + 1] > arr[left] ? left + 1 : left);
			//�����Ƚ�������Һ���ѡ�����Ľϴ���Ǹ���ԭ�����ڵ�Ƚϣ���ѡ���ϴ���Ǹ�
		    largest = arr[largest] > arr[index] ? largest : index;
		    //��������Ԫ�������ôֱ���˳�ѭ��
		    if(largest == index) {
		    	break;
		    }
		    //ĳ�����ӱ��Ҵ��Ǹ����ӵ�λ�þͱ��largest
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
