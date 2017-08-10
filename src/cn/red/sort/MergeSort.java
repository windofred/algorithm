package cn.red.sort;

import java.util.Arrays;

/**
 * 
 * 归并排序
 * 
 * @author red
 *
 */
public class MergeSort {

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
		
		for (int k2 = 0; k2 < temp.length; k2++) {
			a[start + k2] = temp[k2];
		}
	}

	public static void mergeSort(int[] a, int start, int end) {
		int mid = (end + start) / 2;
		if (start < end) {
			mergeSort(a, start, mid);
			mergeSort(a, mid + 1, end);
			merge(a, start, mid, end);
			System.out.println(Arrays.toString(a));
		}
	}

	public static void main(String[] args) {
		int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
	}

}
