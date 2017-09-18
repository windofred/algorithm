package cn.red.offer.second;

/**
 * 斐波拉契数列的应用
 * 用2*1的小矩形横着或者竖着去覆盖更大的矩形，请问用8个2*1的小矩形无重叠地覆盖一个2*8的大矩形，总共有多少种方法？
 * @author sala
 *
 */
public class Problem10_3 {
	
	public static void main(String[] args) {
		long fibonacci = fibonacci(8);
		System.out.println(fibonacci);
	}
	
	public static long fibonacci(int n) {
		long result = 0;
		long preOne = 1;
		long preTwo = 2;
		
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		for (int i = 3; i <= n; i++) {
			result = preOne + preTwo;
			preOne = preTwo;
			preTwo = result;
		}
		
		return result;
	}
	
}
