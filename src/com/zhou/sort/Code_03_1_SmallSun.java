package com.zhou.sort;

public class Code_03_1_SmallSun {

	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return mergeSort(arr, 0, arr.length - 1);
	}

	public static int mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		int mid = l + ((r - l) >> 1);
		return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
	}

	public static int merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		int res = 0;
		while (p1 <= m && p2 <= r) {
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0; //����˫�� �Ѿ��ź���
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		return res;
	}
	// ������ȷ�ķ���
		public static int comparator(int[] arr) {
			if (arr == null || arr.length < 2) {
				return 0;
			}
			int res = 0;
			for (int i = 1; i < arr.length; i++) {
				for (int j = 0; j < i; j++) {
					res += arr[j] < arr[i] ? arr[j] : 0;
				}
			}
			return res;
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
		// ��ӡ����
		public static void printArray(int[] arr) {
			if (arr == null) {
				return;
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

		// ������
		public static void main(String[] args) {
			boolean succeed = true;
			int[] arr1 = {1,3,4,2,5};
			int[] arr2 = copyArray(arr1);
			//С��������
			int result = smallSum(arr1);
			System.out.println(result);
			//��϶���ȷ�ķ������Ƚ�
			if (result != comparator(arr2)) {
				succeed = false;
			}
			System.out.println(succeed ? "Nice!" : "Fucking fucked!");
			printArray(arr1);//�����ù鲢���� �ź����
			printArray(arr2);//��ͨ���淽������û������
		}

}
