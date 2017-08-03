package cn.red.sort;

/**
 * 
 * 1.基本思想：
 *     遍历若干次要排序的数列，每次遍历时，它都会从前往后依次的比较相邻两个数的大小；
 *     如果前者比后者大，则交换它们的位置，这样，一次遍历之后，最大的元素就在数列的末尾
 *     采用相同的方法再次遍历时，第二大的元素就排列在最大元素之前。重复此操作，直到整个数列都有序为止！
 * 
 * 2.时间复杂度：
 *     冒泡排序的时间复杂度是O(N*N)
 *     假设被排序的数列中有N个数。遍历一趟的时间复杂度是O(N)，需要遍历多少次呢？N-1次！因此，冒泡排序的时间复杂度是O(N*N) 
 * 
 * 3.稳定性：
 *     冒泡排序是稳定的算法
 *     算法稳定性--假设在数列中存在a[i] = a[j]，若在排序之前，a[i]在a[j]前面；并且排序之后，a[i]仍然在a[j]前面。则这个算法是稳定的！       
 * 
 */

public class BubbleSort {
	
	public static void main(String[] args) {
		System.out.println("hello world...");
		int[] arr = {20, 40, 30, 10, 60, 50};
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort2(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	//无论是否需要交换，都要进行两两相邻比较，效率较低
	public void bubblesort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		
		//i可以理解为从(n-1)到0的指针
		//j可以理解为从0到(i-1)递增的指针
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
	
	// 增加标志位flag，增加排序的效率
	// 添加一个标记，如果一趟遍历中发生了交换，则标记为true，否则为false。如果某一趟没发生交换，说明排序已经完成！
	public void bubbleSort2(int[] arr) {
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
	
	
}
