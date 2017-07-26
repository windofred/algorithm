package cn.red.offer;

public class FindGreatestSumOfSubArray {

	public static void main(String[] args) {
		int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
		FindGreatestSumOfSubArray m = new FindGreatestSumOfSubArray();
		int i = m.findGreatestSumOfSubArray(array);
		System.out.println(i);
	}

	// 动态规划的思想
	public int findGreatestSumOfSubArray(int[] array) {
		if (array == null || array.length <= 0) {
			return 0;
		}
		
		int local = array[0];
		int global = array[0];
		for (int i = 1; i < array.length; i++) {
			local = Math.max(array[i], local + array[i]);
			global = Math.max(local, global);
		}
		
		return global;
	}

}
