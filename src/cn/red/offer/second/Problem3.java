package cn.red.offer.second;

/**
 * 
 * 找出数组中重复的数字
 * 
 *     在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，
 *     但不知道几个数字是重复了，也不知道每个数字重复了几次。请找出数组中任意一个
 *     重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，那么
 *     对应的输出是重复的数字2或者3。
 * 
 * @author red
 *
 */
public class Problem3 {
	
	public static void main(String[] args) {
		int[] numbers = {2, 3, 1, 0, 2, 5, 3};
		int[] duplication = new int[numbers.length];
		Problem3 p3 = new Problem3();
		boolean b = p3.duplicate(numbers, numbers.length, duplication);
		System.out.println("是否有重复的数字：" + b);
	}
	
	public boolean duplicate(int[] numbers, int length, int[] duplication) {
		
		if (numbers == null || length <= 0) {
			return false;
		}
		
		for (int i = 0; i < length; i++) {
			if (numbers[i] < 0 || numbers[i] > length - 1) {
				return false;
			}
		}
		
		for (int i = 0; i < length; i++) {
			while (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					duplication[0] = numbers[i];
					return true;
				} else {
					int temp = numbers[i];
					numbers[i] = numbers[temp];
					numbers[temp] = temp;
				}
				
			}
		}
		
		return false;
	}
	
}
