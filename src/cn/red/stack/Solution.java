package cn.red.stack;

import java.util.Stack;

public class Solution {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	// 入栈
	public void push(int node) {
		// 直接用栈的push方法
		stack1.push(node);
	}

	// 出栈
	public int pop() {
		Integer re = null;
		if (!stack2.empty()) {
			re = stack2.pop();
		} else {
			while (!stack1.isEmpty()) {
				re = stack1.pop();
				stack2.push(re);
			}
			// 栈2里面有数之后，再从里面取出来
			if (!stack2.empty()) {
				re = stack2.pop();
			}
		}
		
		return re;
	}
	
	public static void main(String[] args) {
		
	}
}
