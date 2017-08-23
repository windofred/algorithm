package cn.red.offer.second;

/**
 * 面试题64：求 1+2+...+n 
 *     要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 
 * @author red
 *
 */
public class Problem64 {

	public static void main(String[] args) {
		Problem64 p64 = new Problem64();
		int sum = p64.Sum_Solution(5);
		System.out.println(sum);
	}
	
	public int Sum_Solution(int n) {
		int sum = 0;
		boolean b = (n > 0) && ((sum += Sum_Solution(n - 1) + n) > 0);
		return sum;
	}

}
