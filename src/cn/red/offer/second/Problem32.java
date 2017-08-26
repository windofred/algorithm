package cn.red.offer.second;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 * @author red
 *
 */

class BinaryTreeNode_32 {
	int val;
	BinaryTreeNode_32 left = null;
	BinaryTreeNode_32 right = null;
	
	public BinaryTreeNode_32(int val) {
		this.val = val;
	}
}

public class Problem32 {
	
	public static void main(String[] args) {
		Problem32 p32 = new Problem32();
		BinaryTreeNode_32 first = new BinaryTreeNode_32(8);
		BinaryTreeNode_32 second = new BinaryTreeNode_32(6);
		BinaryTreeNode_32 third = new BinaryTreeNode_32(10);
		
		first.left = second;
		first.right = third;
		second.left = second.right = null;
		third.left = third.right = null;
		
		ArrayList<Integer> list = p32.printTreeFromTopToBottom(first);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
	
	public ArrayList<Integer> printTreeFromTopToBottom(BinaryTreeNode_32 root) {
		if (root == null) {
			return null;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<BinaryTreeNode_32> node = new LinkedList<BinaryTreeNode_32>();
		
		list.add(root.val);
		node.add(root);
		
		while (node.size() != 0) {
			root = node.poll();
			if (root.left != null) {
				list.add(root.left.val);
				node.add(root.left);
			}
			if (root.right != null) {
				list.add(root.right.val);
				node.add(root.right);
			}
		}
		
		return list;
	}
	
}
