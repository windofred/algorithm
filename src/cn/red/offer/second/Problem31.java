package cn.red.offer.second;

import java.util.Stack;

import cn.red.offer.PushAndPopWithStack;

/**
 * 栈的压入、弹出序列
 * @author sala
 *
 */
public class Problem31 {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 4, 3, 5, 2, 1 };// 是弹出序列
		int[] array3 = { 4, 3, 5, 1, 2 };// 不是弹出序列
		PushAndPopWithStack tmp = new PushAndPopWithStack();
		boolean order = tmp.IsPopOrder(array1, array3);
		System.out.println(order);
	}

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null) {
			return false;
		}
		int point1 = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < pushA.length; i++) {
			if (!stack.isEmpty() && stack.peek() == popA[i]) {
				stack.pop();
			} else {
				if (point1 == pushA.length) {
					return false;
				} else {
					do {
						stack.push(pushA[point1++]);
					} while (stack.peek() != popA[i] && point1 != pushA.length);
					if (stack.peek() == popA[i]) {
						stack.pop();
					} else {
						return false;
					}
				}
			}
		}

		return true;

	}

}
