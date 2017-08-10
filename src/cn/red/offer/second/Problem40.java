package cn.red.offer.second;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * 最小的k个数
 * 
 * @author red
 *
 */
public class Problem40 {
	
	public static void main(String[] args) {
		Problem40 p40 = new Problem40();
		int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
		ArrayList<Integer> list = p40.GetLeastNumbers_Solution(a, 10);
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	/**
	 * 构建堆(最大堆)【堆排序算法的核心】
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void maxHeapDown(int[] arr, int start, int end) {
		// 当前节点的位置
		int current = start;
		// 当前节点的大小
		int tmp = arr[current];
		// 左孩子的位置
		int left = 2 * current + 1;

		for (; left <= end; current = left, left = 2 * left + 1) {
			// 选择左右孩子中的较大者
			if (left < end && arr[left] < arr[left + 1]) {
				// left记录的是左右孩子中的较大者
				left++;
			}
			if (tmp > arr[left]) {
				// 当前节点比其左右孩子都大，说明调整结束
				break;
			} else {
				arr[current] = arr[left];
				arr[left] = tmp;
			}

		}
	}

	/**
	 * 堆排序(从小到大)
	 * 
	 * @param arr
	 * @param n
	 */
	public static void heapSortAsc(int[] arr, int n) {
		int i, tmp;
		for (i = n / 2 - 1; i >= 0; i--) {
			maxHeapDown(arr, i, n - 1);
		}

		// 从最后一个元素开始调整，不断的缩小调整范围直到第一个元素
		for (i = n - 1; i > 0; i--) {
			tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;

			maxHeapDown(arr, 0, i - 1);
		}

	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if (input == null || input.length <= 0 || k < 0 || k > input.length) {
			return list;
		}
		
		//创建临时数组，用以保存最小的k个数
		int[] kArray = Arrays.copyOfRange(input, 0, k);
		heapSortAsc(kArray, k);
		
		for (int i = k; i < input.length; i++) {
			if (input[i] < kArray[k - 1]) {
				kArray[k - 1] = input[i];
				heapSortAsc(kArray, k);
			}
		}
		
		for (int i = 0; i < k; i++) {
			list.add(kArray[i]);
		}
		
		return list;
	}

}
