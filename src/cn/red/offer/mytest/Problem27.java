package cn.red.offer.mytest;

/**
 * 
 * 链表
 * 
 * 面试题27：二叉搜索树与双向链表
 * 
 * 题目： 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author red
 *
 */

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class Problem27 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(14);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(8);
		TreeNode node5 = new TreeNode(12);
		TreeNode node6 = new TreeNode(16);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		
		Problem27 p27 = new Problem27();
		TreeNode node = p27.Convert(root);
		System.out.println(node.right.right.val);
	}

	public TreeNode Convert(TreeNode root) {
		
		if (root == null) {
			return null;
		}
		
		if (root.left == null && root.right == null) {
			return root;
		}
		
		// 1.将左子树构造成双链表，并返回链表头节点
		TreeNode left = Convert(root.left);
		TreeNode p = left;
		// 2.定位至左子树双链表最后一个节点
		while (p != null && p.right != null) {
			p = p.right;
		}
		// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
		if (left != null) {
			p.right = root;
			root.left = p;
		}
		// 4.将右子树构造成双链表，并返回链表头节点
		TreeNode right = Convert(root.right);
		// 5.如果右子树链表不为空的话，将该链表追加到root节点之后
		if (right != null) {
			right.left = root;
			root.right = right;
		}
		return left != null ? left : root;
	}
}
