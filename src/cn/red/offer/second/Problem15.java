package cn.red.offer.second;

/**
 * 
 * 二进制中1的个数
 * 
 * 一个整数减1：最右边的1变成0，如果它的右边还有0，则所有的0都变成1，而它左边的所有位都保持不变
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
			n = (n - 1) & n;// 最右边的1变成0
		}
		return count;
	}
	
}
