package cn.red.offer.second;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的遍历：
 * 
 *     ①层序遍历
 *     ②前序遍历
 *     ③中序遍历
 *     ④后续遍历
 *     
 * @author red
 *
 */

public class Problem32 {
	// 测试
	public static void main(String[] args) {
		Problem32 p32 = new Problem32();
		BinaryTreeNode first = new BinaryTreeNode(8);
		BinaryTreeNode second = new BinaryTreeNode(6);
		BinaryTreeNode third = new BinaryTreeNode(10);
		
		first.left = second;
		first.right = third;
		second.left = second.right = null;
		third.left = third.right = null;
		
		// 测试层序遍历
		/*ArrayList<Integer> list = p32.printTreeFromTopToBottom(first);
		for (Integer integer : list) {
			System.out.println(integer);
		}*/
		
		// 测试前序遍历
	   /*ArrayList<Integer> preList = p32.preOrderTraversal(first);
		for (Integer integer : preList) {
			System.out.printf("%d ", integer);
		}*/
		
		// 测试中序遍历
		/*ArrayList<Integer> inList = p32.inOrderTraversal(first);
		for (Integer integer : inList) {
			System.out.printf("%d ", integer);
		}*/
		
		// 测试后续遍历
		ArrayList<Integer> postList = p32.postOrderTraversal(first);
		for (Integer integer : postList) {
			System.out.printf("%d ", integer);
		}
	}
	
	// 层序遍历
	public ArrayList<Integer> printTreeFromTopToBottom(BinaryTreeNode root) {
		if (root == null) {
			return null;
		}
		// 保存节点的值
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 保存放入队列的节点
		Queue<BinaryTreeNode> node = new LinkedList<BinaryTreeNode>();
		
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
	
	// 前序遍历
	public ArrayList<Integer> preOrderTraversal(BinaryTreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		preOrder(root, result);
		return result;
	}
	public void preOrder(BinaryTreeNode root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		
		result.add(root.val);
		preOrder(root.left, result);
		preOrder(root.right, result);
	}
	
	// 中序遍历
	public ArrayList<Integer> inOrderTraversal(BinaryTreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		inOrder(root, result);
		return result;
	}
	public void inOrder(BinaryTreeNode root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		
		inOrder(root.left, result);
		result.add(root.val);
		inOrder(root.right, result);
	}
	
	// 后续遍历
	public ArrayList<Integer> postOrderTraversal(BinaryTreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		postOrder(root, result);
		return result;
	}
	public void postOrder(BinaryTreeNode root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		
		postOrder(root.left, result);
		postOrder(root.right, result);
		result.add(root.val);
	}
	
}
