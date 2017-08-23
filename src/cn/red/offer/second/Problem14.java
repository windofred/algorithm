package cn.red.offer.second;

/**
 * 
 * 动态规划
 * 
 * 剪绳子
 * 
 * 动态规划特点：
 *     1.问题的目标是求剪出的各段绳子长度的乘积最大值，也就是求一个问题的最优解
 *     2.整体问题的最优解依赖各个子问题的最优解
 *     3.大问题分解成若干个小问题，这些小问题之间还有相互重叠的更小的子问题
 *     4.从上往下分析问题，从下往上求解问题
 * 
 * @author red
 *
 */
public class Problem14 {
	
	public static void main(String[] args) {
		//int maxAfterCutting = Problem14.maxAfterCutting(8);
		int maxAfterCutting2 = Problem14.maxAfterCutting2(10);
		System.out.println(maxAfterCutting2);
	}
	
	/**
	 * 动态规划方法
	 *     时间复杂度：O(n * n)
	 *     空间复杂度：O(n)
	 * @param length
	 * @return
	 */
	public static int maxAfterCutting(int length) {
		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		
		// 存储子问题的最优解
		int[] f = new int[length + 1];
		f[0] = 0;
		f[1] = 1;
		f[2] = 2;
		f[3] = 3;
		
		int result = 0;
		
		for (int i = 4; i <= length; i++) {
			int max = 0;
			
			for (int j = 1; j <= i / 2; j++) {
				int num = f[j] * f[i - j];
				if (num > max) {
					max = num;
				}
				f[i] = max;
			}
		}
		
		result = f[length];
		
		return result;
	}
	
	/**
	 * 
	 * 贪婪算法
	 * 
	 * 策略：
	 *     当n≥5时，我们尽可能多地剪长度为3的绳子；
	 *     当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子
	 * 
	 * 3(n - 2) > 2(n - 3)(n >= 5)
	 * 当剩余长度为4时，则不能再剪去3，因为2 * 2 > 1 * 3
	 * 
	 * @param length
	 * @return
	 */
	public static int maxAfterCutting2(int length) {
		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		
		// 尽可能地剪去长度为3
		int timesOf3 = length / 3;
		
		// 当长度为4时，不能再剪去长度为3
		if (length - timesOf3 * 3 == 1) {
			timesOf3 -= 1;
		}
		
		int timesOf2 = (length - timesOf3 * 3) / 2;
		
		return (int)Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);
		
	}
	
}
