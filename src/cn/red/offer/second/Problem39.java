package cn.red.offer.second;

import cn.red.offer.GetHalfNumber;

/**
 * 数组中出现次数超过一半的数字
 * @author sala
 *
 */
public class Problem39 {

	public static void main(String[] args) {
		GetHalfNumber ghn = new GetHalfNumber();
		int[] array = { 2, 2, 2, 2, 2, 3, 4, 5, 6 };
		// int[] array2 = {3, 2, 4, 2, 5, 2, 6, 2, 2};
		int halfNum_Solution = ghn.MoreThanHalfNum_Solution(array);
		System.out.println(halfNum_Solution);
	}

	public int MoreThanHalfNum_Solution(int[] array) {
		int length = array.length;
		if (checkInvalidArray(array, length)) {
			return 0;
		}

		int result = array[0];
		int times = 1;
		for (int i = 1; i < length; i++) {
			if (times == 0) {
				result = array[i];
				times = 1;
			} else if (array[i] == result) {
				times++;
			} else {
				times--;
			}
		}

		if (!checkMoreThanHalf(array, length, result)) {
			return 0;
		}

		return result;
	}

	boolean isInvalidArray = false;

	public boolean checkInvalidArray(int[] array, int length) {
		isInvalidArray = false;
		if (array == null || array.length == 0) {
			isInvalidArray = true;
		}
		return isInvalidArray;
	}

	public boolean checkMoreThanHalf(int[] array, int length, int number) {
		int times = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] == number) {
				times++;
			}
		}

		boolean isMoreThanHalf = true;
		if (times * 2 <= length) {
			isMoreThanHalf = false;
		}

		return isMoreThanHalf;
	}

}
