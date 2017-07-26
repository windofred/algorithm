package cn.red.offer;

/**
 * 整数的指数次方
 * @author red
 *
 */
public class ExponentWithInt {
	
	public static void main(String[] args) throws Exception {
		ExponentWithInt ewi = new ExponentWithInt();
		System.out.println(ewi.power(2.0, 4));
	}
	
	/**
	 * 
	 * @param base 底数
	 * @param exponent 指数
	 * @return
	 * @throws Exception 
	 */
	public double power(double base, int exponent) throws Exception {
		double result = 0.0;
		// 1.如果底数为0且指数为负数
		if (equal(base, 0.0) && exponent < 0) {
			throw new Exception("0的负数次幂没有意义");
		}
		
		// 2.如果指数小于0
		if (exponent < 0) {
			result = 1 / powerWithExponent(base, -exponent);
		} else {
			// 3.如果指数大于等于0
			result = powerWithExponent(base, exponent);
		}
		
		return result;
	}
	
	private double powerWithExponent(double base, int exponent) {
		// 1.如果exponent等于0
		if (exponent == 0) {
			return 1;
		}
		
		// 2.如果exponent等于1
		if (exponent == 1) {
			return base;
		}
		
		// 3.
		double result = 1.0;
		for (int i = 1; i <= exponent; i++) {
			result = result * base;
		}
		return result;
	}
	
	// 判断两个小数是否相等
	private boolean equal(double num1, double num2) {
		if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)) {
			return true;
		} else {
			return false;
		}
	}
	
}
