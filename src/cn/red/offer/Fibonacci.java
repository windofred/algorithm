package cn.red.offer;

public class Fibonacci {
	
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		long fibonacci = fib.fibonacci(4);
		System.out.println(fibonacci);
	}
	
	public long fibonacci(int n) {
		long result = 0;
		long preOne = 0;
		long preTwo = 1;
		
		if (n == 0) {
			return preOne;
		}
		
		if (n == 1) {
			return preTwo;
		}
		
		for (int i = 2; i <= n; i++) {
			result = preOne + preTwo;
			preOne = preTwo;
			preTwo = result;
		}
		
		return result;
	}
}
