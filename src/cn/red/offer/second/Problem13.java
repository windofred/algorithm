package cn.red.offer.second;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;

/**
 * 机器人的运动范围
 * 
 * @author sala
 *
 */
public class Problem13 {

	public static void main(String[] args) {
		//List a = new ArrayList<DelayQueue>();
	}

	public int movingCount(int threshold, int rows, int cols) {
		int flag[][] = new int[rows][cols]; // 记录是否已经走过
		return helper(0, 0, rows, cols, flag, threshold);
	}

	private int helper(int i, int j, int rows, int cols, int[][] flag,
			int threshold) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1) {
			return 0;
		}
		flag[i][j] = 1;
		return helper(i - 1, j, rows, cols, flag, threshold)
				+ helper(i + 1, j, rows, cols, flag, threshold)
				+ helper(i, j - 1, rows, cols, flag, threshold)
				+ helper(i, j + 1, rows, cols, flag, threshold) + 1;
	}

	private int numSum(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}

}
