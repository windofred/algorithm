package cn.red.sort.mytest;

public class PartitionTest {

	public static void main(String[] args) {
		//int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
		//int number = PartitionTest.moreThanHalfNumber(a, a.length);
		
		int[] a = {40, 60, 30, 10, 20, 50};
		PartitionTest.quickSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		
		//System.out.println(number);
	}
	
	// 检验最多数字是否超过数组的一半
	public static boolean checkMoreThanHalf(int[] a, int length, int number) {
		int times = 0;
		for (int i = 0; i < length; i++) {
			if (a[i] == number) {
				times++;
			}
		}
		
		boolean isMoreThanHalf = true;
		if (times * 2 <= length) {
			isMoreThanHalf = false;
		}
		
		return isMoreThanHalf;
	}
	
	// 超过数组一半的数字
	public static int moreThanHalfNumber(int[] a, int length) {
		if (a == null || a.length <= 0) {
			return -1;
		}
		int middle = length >> 1;
		int start = 0;
		int end = length - 1;
		
		int index = partition(a, start, end);
		while (index != middle) {
			if (index > middle) {
				end = index - 1;
				index = partition(a, start, end);
			} else {
				start = index + 1;
				index = partition(a, start, end);
			}
		}
		
		int result = a[middle];
		
		if (!checkMoreThanHalf(a, length, result)) {
			result = -1;
		}
		
		return result;
	}

	// 快速排序的基础 通过一趟排序，返回主元的下标
	public static int partition(int[] a, int left, int right) {
		if (a == null || a.length <= 0) {
			return -1;
		}
		
		int i = left;
		int j = right;
		// 基准值
		int x = a[i];// 总是指向当前数组的首元素，将首元素选为基准值

		while (i < j) {
			while (i < j && a[j] > x) {// 从右向左查找比x小的数
				j--;
			}
			if (i < j) {
				a[i++] = a[j];// 将a[j]的值赋给a[i]
			}
			while (i < j && a[i] < x) {// 从左向右查找比x大的数
				i++;
			}
			if (i < j) {
				a[j--] = a[i];// 将a[i]的值赋给a[j]
			}
		}

		a[i] = x;// 当i >= j时，停止查找和交换，设置a[i] = x
		
		return i;
	}
	
	public static void quickSort(int[] a) {
		if (a == null || a.length <= 0) {
			return;
		}
		
		// 通过递归进行排序
		quickSort(a, 0, a.length - 1);
	}
	
	public static void quickSort(int[] a, int start, int end) {
		if (start < end) {
			// 获取主元
			int key = partition(a, start, end);
			// 对主元左侧的序列进行快速排序
			quickSort(a, start, key - 1);
			// 对主元右侧的序列进行快速排序
			quickSort(a, key + 1, end);
		}
	}

}
