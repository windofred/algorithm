package cn.red.offer;

import java.util.Stack;

/**
 * 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出
 * 如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止
 * 如果所有数字都压入了栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列
 * @author red
 *
 */
public class PushAndPopWithStack {
	
	public static void main(String[] args) {
		int[] array1 = {1, 2, 3, 4, 5};
		int[] array2 = {4, 3, 5, 2, 1};// 是弹出序列
		int[] array3 = {4, 3, 5, 1, 2};// 不是弹出序列
		PushAndPopWithStack tmp = new PushAndPopWithStack();
		boolean order = tmp.IsPopOrder(array1, array3);
		System.out.println(order);
	}
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
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
					} while(stack.peek() != popA[i] && point1 != pushA.length);
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
