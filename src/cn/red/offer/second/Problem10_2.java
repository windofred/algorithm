package cn.red.offer.second;

import cn.red.offer.JumpStep;

/**
 * 青蛙跳台阶
 * 
 * @author sala
 *
 */
public class Problem10_2 {

	public static void main(String[] args) {
		JumpStep fib = new JumpStep();
		int jumpFloor = fib.JumpFloor(5);
		System.out.println(jumpFloor);
	}

	public int JumpFloor(int target) {
		int result = 0;
		int preOne = 1;
		int preTwo = 2;

		if (target == 1) {
			return 1;
		}

		if (target == 2) {
			return 2;
		}

		for (int i = 3; i <= target; i++) {
			result = preOne + preTwo;
			preOne = preTwo;
			preTwo = result;
		}

		return result;

	}

}
