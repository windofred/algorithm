package cn.red.offer;

import java.util.Stack;

public class StackWithMin {

	public static void main(String[] args) {
		StackWithMin swm = new StackWithMin();
		swm.push(3);
		swm.push(2);
		swm.push(1);
		swm.push(4);
		swm.push(5);
		
		System.out.println(swm.min());
	}

	// 数据栈
	Stack<Integer> dataStack = new Stack<Integer>();
	// 辅助栈
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int node) {
		dataStack.push(node);
		if (minStack.size() == 0 || node <= minStack.peek()) {
			minStack.push(node);
		} else {
			minStack.push(minStack.peek());
		}
	}

	public void pop() {
		if (dataStack.size() == 0 || minStack.size() == 0) {
			return;
		}
		minStack.pop();
		dataStack.pop();
	}

	public int top() {
		return dataStack.peek();
	}

	public int min() {
		if (minStack.size() == 0) {
			return -1;
		}
		return minStack.peek();
	}

}
