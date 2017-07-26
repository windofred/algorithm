package cn.red.leetcode;

/**
 * 树的子结构
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

public class SubTree {
	// 测试用例
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(8);
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(9);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		
		root1.left = node1;
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.left = node5;
		node4.right = node6;
		
		TreeNode root2 = new TreeNode(8);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(2);
		
		root2.left = a;
		root2.right = b;
		
		SubTree st = new SubTree();
		boolean subtree = st.hasSubtree(root1, root2);
		System.out.println(subtree);
	}

	public boolean hasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = doesTree1HaveTree2(root1, root2);
			}
			if (!result) {
				result = doesTree1HaveTree2(root1.left, root2);
			}
			if (!result) {
				result = doesTree1HaveTree2(root1.right, root2);
			}
		}
		
		return result;
		
	}
	
	private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		
		return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
	}

}
