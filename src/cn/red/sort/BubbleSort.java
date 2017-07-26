package cn.red.sort;

/**
 * 1.冒泡排序思想：
 * 	① 两两相邻比较 
 */

public class BubbleSort {
	
	//无论是否需要交换，都要进行两两相邻比较，效率较低
	public static void bubblesort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		
		int i, j;
		for (i = arr.length - 1; i > 0; i--) {
			for (j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
	public static void bubbleSort2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		
		int i, j, flag;
		for (i = arr.length - 1; i > 0; i--) {
			flag = 0;
			for (j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					// 如果发生交换，则置标志位为1
					flag = 1;
				}
			}
			// 如果没有发生交换，说明数组已经有序
			if (flag == 0) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("hello world...");
		int[] arr = {5, 4, 3, 2, 1};
		BubbleSort.bubbleSort2(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
