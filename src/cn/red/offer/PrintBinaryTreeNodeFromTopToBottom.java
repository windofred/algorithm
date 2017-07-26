package cn.red.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode3 {
	int val = 0;
	TreeNode3 left = null;
	TreeNode3 right = null;
	
	public TreeNode3(int val) {
		this.val = val;
	}
}

/**
 * 从上往下打印二叉树
 * @author red
 *
 */
public class PrintBinaryTreeNodeFromTopToBottom {

	public static void main(String[] args) {
		TreeNode3 root1 = new TreeNode3(8);
		TreeNode3 node1 = new TreeNode3(6);
		TreeNode3 node2 = new TreeNode3(10);
		TreeNode3 node3 = new TreeNode3(5);
		TreeNode3 node4 = new TreeNode3(7);
		TreeNode3 node5 = new TreeNode3(9);
		TreeNode3 node6 = new TreeNode3(11);
		
		root1.left = node1;
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		
		PrintBinaryTreeNodeFromTopToBottom tmp = new PrintBinaryTreeNodeFromTopToBottom();
		ArrayList<Integer> list = tmp.PrintFromTopToBottom(root1);
		for (Integer i : list) {
			System.out.println(i);
		}
	}

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode3 root) {
		if (root == null) {
			return null;
		}
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Queue<TreeNode3> queue = new LinkedList<TreeNode3>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode3 node = queue.poll();
			arrayList.add(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		
		return arrayList;
	}

}
