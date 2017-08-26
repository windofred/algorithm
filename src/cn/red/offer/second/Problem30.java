package cn.red.offer.second;

import java.util.Stack;

/**
 * 包含min函数的栈
 * @author red
 *
 */
public class Problem30 {
	// 数据栈
	private static Stack<Integer> mStack = new Stack<Integer>();
	// 辅助栈
	private static Stack<Integer> minStack = new Stack<Integer>();
	
	public static void main(String[] args) {
		Problem30 p30 = new Problem30();
		p30.push(3);
		System.out.println(p30.min());
		p30.push(4);
		System.out.println(p30.min());
		p30.push(2);
		System.out.println(p30.min());
		p30.push(1);
		System.out.println(p30.min());
		p30.pop();
		System.out.println(p30.min());
		p30.pop();
		System.out.println(p30.min());
		p30.push(0);
		System.out.println(p30.min());
		
	}
	
	public void push(int i) {
		mStack.push(i);
		if (minStack.size() == 0 || i < minStack.peek()) {
			minStack.push(i);
		} else {
			minStack.push(minStack.peek());
		}
	}
	
	public void pop() {
		assert(minStack.size() > 0 && mStack.size() > 0);
		mStack.pop();
		minStack.pop();
	}
	
	public int min() {
		assert(minStack.size() > 0 && mStack.size() > 0);
		return minStack.peek();
	}
	
}
