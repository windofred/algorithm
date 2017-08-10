package cn.red.offer.second;

public class Problem51 {
	
	//static long count = 0;
	
	public int InversePairs(int[] array) {
		int i = Problem51.mergeSort(array, 0, array.length - 1);
		return i;
	}

	public static int mergeSort(int[] input, int left, int right) {
		// 分治
		int mid = (left + right) / 2;
		if (left < right) {
			// 左边
			int start = mergeSort(input, left, mid);
			// 右边
			int end = mergeSort(input, mid + 1, right);
			// 左右归并
			int i = merge(input, left, mid, right);
			
			return i + start + end;
		}
		
		return 0;
	}

	/**
	 * 二路归并
	 * 
	 * @param input
	 * @param left左数组的第一个元素的索引
	 * @param center左数组的最后一个元素的索引
	 *            ，center+1是右数组第一个元素的索引
	 * @param right右数组最后一个元素的索引
	 */
	public static int merge(int[] input, int left, int center, int right) {
		int[] tempArray = new int[right - left + 1];
		int mid = center + 1;
		int temp = left;
		int current = 0;
		int count = 0;
		while (left <= center && mid <= right) {
			if (input[left] > input[mid]) {
				tempArray[current++] = input[mid++];
				/*
				 * 如果input[left]>input[mid]，那么表明下标为left~center的值都会比input[mid]大;
				 * (5,7,8)(4,9)合并为 3+0+0+0
				 */
				count += center - left + 1;
			} else {
				tempArray[current++] = input[left++];
			}
		}
		// 只会执行一个
		while (left <= center) {
			tempArray[current++] = input[left++];
		}
		while (mid <= right) {
			tempArray[current++] = input[mid++];
		}
		current = 0;
		while (temp <= right) {
			input[temp++] = tempArray[current++];
		}
		
		return count;
	}

	public static void main(String[] args) {
		int[] a = {7, 5, 6, 4};
		//System.out.println("" + Problem51.count);
		Problem51 p51 = new Problem51();
		int i = p51.InversePairs(a);
		System.out.println("逆序对：" + i);
	}
}
