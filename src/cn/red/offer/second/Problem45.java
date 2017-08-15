package cn.red.offer.second;

import java.math.BigInteger;

/**
 * 
 * 把数组排成最小的数
 * 
 * @author red
 *
 */
public class Problem45 {

	public static void main(String[] args) {
		Problem45 p45 = new Problem45();
		int[] array = {3, 32, 321};
		String number = p45.PrintMinNumber(array);
		System.out.println(number);
	}
	
	public String PrintMinNumber(int[] numbers) {
		String res = "";
		if (numbers == null || numbers.length == 0) {
			return res;
		}
		int len = numbers.length;
		sort(numbers, 0, len - 1);// 使用快排将数组排序
		for (int i = 0; i < len; i++) {
			res = concat(res, numbers[i] + "");// 依次加入到字符串的正确位置
		}
		return res;
	}

	public String concat(String a, String b) {
		BigInteger t1 = new BigInteger(a + b);
		BigInteger t2 = new BigInteger(b + a);
		return t1.compareTo(t2) == 1 ? (b + a) : (a + b);// 使用java的BigInteger来判断组合方式
	}

	/**
	 * 快排
	 * @param arr
	 * @param low
	 * @param high
	 */
	public void sort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = getMiddle(arr, low, high);
			sort(arr, low, mid - 1);
			sort(arr, mid + 1, high);
		}
	}

	public int getMiddle(int[] arr, int low, int high) {
		int key = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= key) {
				high--;
			}
			arr[low] = arr[high];
			while (low < high && arr[low] <= key) {
				low++;
			}
			arr[high] = arr[low];
		}
		arr[low] = key;
		return low;
	}

}
