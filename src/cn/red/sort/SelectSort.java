package cn.red.sort;

public class SelectSort {
	
	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 1};
		SelectSort.selectSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void selectSort(int[] arr) {
		int i;
		int j;
		int min;
		
		for (i = 0; i < arr.length; i++) {
			min = i;
			for (j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					min = j;
				}
			}
			
			if (min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}
	
}
