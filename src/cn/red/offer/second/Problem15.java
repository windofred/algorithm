package cn.red.offer.second;

/**
 * 
 * 二进制中1的个数
 * 
 * @author red
 *
 */
public class Problem15 {
	
	public static void main(String[] args) {
		Problem15 p15 = new Problem15();
		int numberOf1 = p15.numberOf1(7);
		System.out.println(numberOf1);
	}
	
	public int numberOf1(int n) {
		int count = 0;
		while (n > 0) {
			++count;
			n = (n - 1) & n;
		}
		return count;
	}
	
}
