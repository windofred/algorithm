package cn.red.temp;

import org.junit.Test;

/**
 * 基本的查找和排序算法 1.查找 二分查找 ☆ 2.排序 冒泡排序 插入排序 选择排序 希尔排序 归并排序 快速排序 ☆ 堆排序
 * 备注：时间复杂度及各个排序算法的比较
 * 
 * @author Administrator
 *
 */
public class SearchAndSortTest {

	@Test
	public void testBinarySearch() {
		SearchAndSortTest sast = new SearchAndSortTest();
		int[] array = { 10, 20, 30, 40, 50, 60 };
		int search = sast.binarySearch(array, 50);
		System.out.println("所在位置是：" + search);
	}

	@Test
	public void bubbleSortTest() {
		SearchAndSortTest sast = new SearchAndSortTest();
		int[] array = { 20, 10, 30, 50, 40, 60 };
		sast.bubbleSort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
	}

	@Test
	public void quickSortTest() {
		SearchAndSortTest sast = new SearchAndSortTest();
		int[] array = { 20, 10, 30, 50, 40, 60 };
		sast.quickSort(array, 0, array.length - 1);

		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
	}
	
	@Test
	public void selectSortTest() {
		SearchAndSortTest sast = new SearchAndSortTest();
		int[] array = { 20, 10, 30, 50, 40, 60 };
		sast.selectSort(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
	}

	// 二分查找
	public int binarySearch(int[] array, int key) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (array[middle] == key) {
				return middle;
			} else if (array[middle] > key) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}

		return -1;
	}

	// 冒泡排序
	public void bubbleSort(int[] array) {
		// 标志位，用于减少比较的次数
		boolean flag = true;

		for (int i = array.length - 1; i > 0; i--) {

			flag = false;

			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;

					flag = true;
				}
			}

			if (!flag) {
				break;
			}
		}
	}

	// 快速排序
	public void quickSort(int[] array, int left, int right) {

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
	
	// 选择排序
	public void selectSort(int[] array) {
		int i;
		int j;
		int min;
		
		for (i = 0; i < array.length; i++) {
			min = i;
			for (j = i + 1; j < array.length - 1; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
	}
	
	// 归并排序
	
	public void mergeSort(int[] array, int left, int right) {
		int middle = (left + right) / 2;
		if (left < right) {
			
		}
	}
	
	public void merge(int[] array, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		
		while (i <= mid && j <= right) {
			if (array[i] < array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}
		
		while (i <= mid) {
			temp[k++] = array[i++];
		}
		
		while (j <= right) {
			temp[k++] = array[j++];
		}
		
		for (int k2 = 0; k2 < array.length; k2++) {
			array[left + k2] = temp[k2];
		}
	}
	

}
