package cn.red.offer.second;

/**
 * 不用加减乘除做加法
 * @author red
 *
 */
public class Problem65 {
	
	public static void main(String[] args) {
		Problem65 p65 = new Problem65();
		int add = p65.add(12, 13);
		System.out.println(add);
	}
	
	public int add(int num1, int num2) {
		int sum, carry;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
			
		} while(num2 != 0);
		
		return num1;
	}
	
}
