package cn.red.temp;

public class InsertSortTest {
	
	public static void main(String[] args) {
		int[] a = {9, 2, 7, 19, 100, 97, 63, 208, 55, 78};
		// 插入排序测试
		/*InsertSortTest.intInsertionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}*/
		
		// 选择排序测试
		/*InsertSortTest.intSelectSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}*/
		
		// 快速排序测试
		/*InsertSortTest.intQuickSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}*/
		
		// 冒泡排序测试
		/*InsertSortTest.intBubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}*/
		
		// 堆排序测试
		// 构建最大堆
		/*for (int i = a.length / 2 - 1; i >= 0; i--) {
			maxHeapify(a, a.length, i);
		}
		// 堆排序
		InsertSortTest.intHeapSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}*/
		
		// 归并排序
		intMergeSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
	}
	
	// 插入排序
	public static void intInsertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j;
			for (j = i - 1; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
	}
	
	// 选择排序
	public static void intSelectSort(int[] a) {
		int i, j, min;
		for (i = 0; i < a.length; i++) {
			min = i;
			for (j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
	}
	
	// 快速排序
	public static int partition(int[] a, int low, int high) {
		int key = a[low];
		while (low < high) {
			while (low < high && a[high] >= key) {
				high--;
			}
			a[low] = a[high];
			while (low < high && a[low] <= key) {
				low++;
			}
			a[high] = a[low];
		}
		a[low] = key;
		return low;
	}
	public static void intQuickSort(int[] a, int low, int high) {
		if (low < high) {
			int pivot = InsertSortTest.partition(a, low, high);
			intQuickSort(a, low, pivot - 1);
			intQuickSort(a, pivot + 1, high);
		}
	}
	
	// 冒泡排序
	public static void intBubbleSort(int[] a) {
		int i, j;
		boolean flag;
		for (i = a.length - 1; i > 0; i--) {
			flag = false;
			for (j = 0; j < i; j++) {
				if (a[j + 1] < a[j]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true;
				}
			}
			
			if (flag == false) {
				break;
			}
		}
	}
	
	// 堆排序
	public static void maxHeapify(int[] a, int heapSize, int index) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		
		int largest = index;
		if (left < heapSize && a[index] < a[left]) {
			largest = left;
		}
		if (right < heapSize && a[largest] < a[right]) {
			largest = right;
		}
		if (largest != index) {
			int temp = a[index];
			a[index] = a[largest];
			a[largest] = temp;
			maxHeapify(a, heapSize, largest);
		}
	}
	public static void intHeapSort(int[] a) {
		for (int i = a.length - 1; i > 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			maxHeapify(a, i, 0);
		}
	}
	
	// 归并排序
	public static void merge(int[] a, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;
		
		while (i <= mid && j <= end) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		while (j <= end) {
			temp[k++] = a[j++];
		}
		
		for (int k2 = 0; k2 < k; k2++) {
			a[start + k2] = temp[k2];
		}
	}
	public static void intMergeSort(int[] a, int start, int end) {
		int mid = (start + end) / 2;
		if (start < end) {
			intMergeSort(a, start, mid);
			intMergeSort(a, mid + 1, end);
			merge(a, start, mid, end);
		}
	}
	
}
