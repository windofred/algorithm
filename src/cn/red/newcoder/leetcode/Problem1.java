package cn.red.newcoder.leetcode;

/**
 * 
 * 求二叉树的最小深度
 * 
 * @author red
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class Problem1 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		node1.right = node2;
		
		Problem1 p1 = new Problem1();
		int minDepth = p1.run(root);
		System.out.println("树的最小深度：" + minDepth);
	}

	public int run(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// 递归计算左子树的最小深度
		int minLeft = run(root.left);
		// 递归计算右子树的最小深度
		int minRight = run(root.right);
		// 如果一边为空
		if (minLeft == 0 || minRight == 0) {
			// 如果右子树为空，则返回左子树的最小深度 + 1
			// 如果左子树为空，则返回右子树的最小深度 + 1
			return minLeft >= minRight ? minLeft + 1 : minRight + 1;
		}
		// 返回左右子树中最小深度 + 1
		return Math.min(minLeft, minRight) + 1;
	}

}
