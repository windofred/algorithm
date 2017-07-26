package cn.red.sort;

public class QuickSort {
	
	public static void quickSort(int[] arr, int left, int right) {
		if (arr == null || arr.length == 0) {
			return;
		}
		
		if (left > right) {
			return;
		}
		
		if (left < right) {
			int i, j, x;
			i = left;
			j = right;
			x = arr[i];
			while (i < j) {
				// 从右向左找第一个小于x的数
				while (i < j && arr[j] > x) {
					j--;
				}
				if (i < j) {
					arr[i++] = arr[j];
				}
				// 从左向右找第一个大于x的数
				while (i < j && arr[i] < x) {
					i++;
				}
				if (i < j) {
					arr[j++] = arr[i];
				}
			}
			arr[i] = x;
			quickSort(arr, left, i - 1);
			quickSort(arr, i+1, right);
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 1};
		QuickSort.quickSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}
