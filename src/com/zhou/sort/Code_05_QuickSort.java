package com.zhou.sort;

import java.util.Arrays;

public class Code_05_QuickSort {
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			//int[] p = partition(arr, l, r);
			int[] p = partition1(arr, l, r);
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}
	}

	public static int[] partition1(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r + 1;  
		int num = arr[r];
		int cur = l;
		while (cur < more) {
			if (arr[cur] < num) {
				swap(arr, ++less, cur++); //С������ ������һ��λ�ã���ǰָ��������
			} else if (arr[cur] > num) {
				swap(arr, --more, cur); //�������� ������һ��λ�ã���ǰָ�벢����
			} else {
				cur++; // ����ǵ��ڵĻ�������С�����򶼲�������ǰָ�������ƶ�
			}
		}
		return new int[] { less + 1, more - 1}; //�����м��������� �����±�λ��
	}
	
	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;  //��Ϊ���������趨 ���һ��λ�õ�����Ϊ���������ˣ�������Ϊmore = r + 1���������û�н������һ�����Ĺ��̣���������±�Խ��
		int cur = l;
		while (cur < more) {
			if (arr[cur] < arr[r]) {
				swap(arr, ++less, cur++); //С������ ������һ��λ�ã���ǰָ��������
			} else if (arr[cur] > arr[r]) {
				swap(arr, --more, cur); //�������� ������һ��λ�ã���ǰָ�벢����
			} else {
				cur++; // ����ǵ��ڵĻ�������С�����򶼲�������ǰָ�������ƶ�
			}
		}
		swap(arr, more, r); //more �Ǵ�������ĵ�һ��λ�ã����������һ��λ���ϵ�����������Ϊ��ʼĬ�����һ�����������ڴ�������ġ�
		return new int[] { less + 1, more }; //�����м��������� �����±�λ��
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
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

	// for test
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

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}

}