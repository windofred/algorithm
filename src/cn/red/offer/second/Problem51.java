package cn.red.offer.second;

public class Problem51 {
	
	public static void main(String[] args) {
		int[] a = {7, 5, 6, 4};
		int pairs = inversePairs(a);
		System.out.println(pairs);
	}

	// 数组中的逆序对
	public static int inversePairs(int[] a) {
		int[] copy = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			copy[i] = a[i];
		}
		// 统计逆序对
		int count = mergeCount(a, copy, 0, a.length - 1);
		return count;
	}
	
	// 统计逆序对
	public static int mergeCount(int[] a, int[] copy, int start, int end) {
		int mid = (end - start) / 2;
		int leftCount = mergeCount(copy, a, start, start + mid);
		int rightCount = mergeCount(copy, a, start + mid + 1, end);
		
		int i = start + mid;
		int j = end;
		int index = end;
		int count = 0;
		while (i >= start && j >= start + mid + 1) {
			if (a[i] > a[j]) {
				copy[index--] = a[i--];
				count += j - start - mid;
			} else {
				copy[index--] = a[j--];
			}
		}
		for (; i >= start; i--) {
			copy[index--] = a[i];
		}
		for (; j >= start + mid + 1; j--) {
			copy[index--] = a[j];
		}
		return leftCount + rightCount + count;
	}
	
}
