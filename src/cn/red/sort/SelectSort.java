package cn.red.sort;


/**
 * 
 * 1.基本思想：
 *     首先在未排序的数列中找到最小(或最大)元素，然后将其存放到数列的起始位置
 *     接着，再从剩余未排序的元素中继续寻找最小(或最大)元素，然后放到已排序序列的末尾。
 *     以此类推，直到所有元素均排序完毕。
 *     
 * 2.时间复杂度
 *     选择排序的时间复杂度是O(N*N)
 *     假设被排序的数列中有N个数。遍历一趟的时间复杂度是O(N)，需要遍历多少次呢？N-1！因此，选择排序的时间复杂度是O(N*N)。
 *     
 * 3.稳定性
 *     选择排序是稳定的算法，它满足稳定算法的定义。        
 * 
 * @author red
 *
 */
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
