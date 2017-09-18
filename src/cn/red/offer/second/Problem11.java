package cn.red.offer.second;

import cn.red.offer.RotationArray;

/**
 * 旋转数组的最小数字
 * 
 * @author sala
 *
 */
public class Problem11 {

	public static void main(String[] args) {
		// int[] arr = new int[]{3, 4, 5, 1, 2};
		// int[] arr = {1, 0, 1, 1, 1};
		int[] arr = { 1, 1, 1, 0, 1 };
		RotationArray ra = new RotationArray();
		int minNum = ra.findMinNum(arr);
		System.out.println(minNum);
	}

	public Integer findMinNum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}

		int index1 = 0;
		int index2 = arr.length - 1;
		int midIndex = index1;
		while (arr[index1] >= arr[index2]) {
			// 如果index1和index2相邻，则index2即为旋转数组中最小的元素
			if ((index2 - index1) <= 1) {
				midIndex = index2;
				break;
			}

			// 如果index1和index2不相邻
			midIndex = (index1 + index2) / 2;

			if (arr[index1] == arr[index2] && arr[index1] == arr[midIndex]) {
				if (arr[index1 + 1] != arr[index2 - 1]) {
					midIndex = arr[index1 + 1] < arr[index2 - 1] ? (index1 + 1)
							: (index2 - 1);
					break;
				} else {
					index1++;
					index2--;
				}
			} else {
				if (arr[midIndex] >= arr[index1]) {
					index1 = midIndex;
				} else if (arr[index2] >= arr[midIndex]) {
					index2 = midIndex;
				}
			}

		}

		return arr[midIndex];

	}

}
