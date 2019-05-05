package com.zhou.sort;

public class Code_04_NetherlandsFlag {

	public static int[] partition(int[] arr, int l, int r, int num) {
		int less = l - 1;
		int more = r + 1;
		int cur = l;
		while(cur < more) {
			if(arr[cur] < num) {
				swap(arr, ++less, cur++);
			}else if(arr[cur] > num) {
				swap(arr, --more, cur);
			}else {
				cur++;
			}
		}
		return new int[] {less + 1, more - 1};
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test  生成随机数组
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {1,0,2,0,1,0,2,0,2,1};
		int[] fild = partition(arr, 0, arr.length - 1, 1);
		System.out.print("与1相等的位置在...到...位置之间：");
		printArray(fild);
		System.out.println("");
		printArray(arr);

	}

	private static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
