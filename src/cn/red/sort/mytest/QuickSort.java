package cn.red.sort.mytest;

public class QuickSort {
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] tempArray = {30, 40, 60, 10, 20, 50};
		qs.quickSort(tempArray, 0, tempArray.length - 1);
		
		for (int i = 0; i < tempArray.length; i++) {
			System.out.print(tempArray[i] + " ");
		}
	}
	
	public void quickSort(int[] array, int left, int right) {
		
		if (array == null || array.length <= 0) {
			return;
		}
		
		if (left < right) {
			int i = left;
			int j = right;
			int x = array[i];
			
			while (i < j) {
				while (i < j && array[j] > x) {
					j--;
				}
				if (i < j) {
					array[i++] = array[j];
				}
				while (i < j && array[i] < x) {
					i++;
				}
				if (i < j) {
					array[j--] = array[i];
				}
			}
			
			array[i] = x;
			
			quickSort(array, left, i - 1);
			quickSort(array, i + 1, right);
		}
		
	}
	
}
