package cn.red.offer.second;

/**
 * 斐波拉契数列
 * @author red
 *
 */
public class Problem10 {

	public static void main(String[] args) {
		Problem10 p10 = new Problem10();
		long fibonacci = p10.fibonacci(10);
		System.out.println(fibonacci);
	}
	
	public long fibonacci(int n) {
		long result = 0;
		long preOne = 0;
		long preTwo = 1;
		
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		for (int i = 2; i <= n; i++) {
			result = preOne + preTwo;
			preOne = preTwo;
			preTwo = result;
		}
		
		return result;
	}
	
}
