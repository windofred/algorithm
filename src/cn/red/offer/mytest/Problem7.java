package cn.red.offer.mytest;

import java.util.Stack;

import org.junit.Test;

/**
 * 
 * 用两个栈实现队列
 * 
 * 功能：
 *     1.在队列的尾部添加节点
 *     2.在队列的头部删除节点
 *     
 * 删除一个元素的步骤：当stack2中不为空时，在stack2中的栈顶元素是最先进入队列的元素，可以弹出。
 * 如果stack2为空时，我们把stack1中的元素逐个弹出并压入stack2。由于先进入队列的元素被压到
 * stack1的底端，经过弹出和压入之后就处于stack2的顶端了，又可以直接弹出。    
 * 
 * @author red
 *
 */
public class Problem7<T> {
	
	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();
	
	public static void main(String[] args) throws Exception {
		Problem7<String> p7 = new Problem7<>();
		p7.appendTail("1");
		p7.appendTail("2");
		p7.appendTail("3");
		String delteHead = p7.delteHead();
		System.out.println(delteHead);
		
		p7.appendTail("4");
		
	}
	
	public void appendTail(T t) {
		stack1.push(t);
	}
	
	public T delteHead() throws Exception {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		
		if (stack2.isEmpty()) {
			throw new Exception("队列为空，不能删除");
		}
		
		return stack2.pop();
	}
	
}
