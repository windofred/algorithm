package cn.red.offer;

class TreeNode2 {
	int val = 0;
	TreeNode2 left = null;
	TreeNode2 right = null;

	public TreeNode2(int val) {
		this.val = val;
	}
}

public class MirrorOfTree {

	public static void main(String[] args) {
		// 构造一个二叉树
		TreeNode2 root1 = new TreeNode2(8);
		TreeNode2 node1 = new TreeNode2(6);
		TreeNode2 node2 = new TreeNode2(10);
		TreeNode2 node3 = new TreeNode2(5);
		TreeNode2 node4 = new TreeNode2(7);
		TreeNode2 node5 = new TreeNode2(9);
		TreeNode2 node6 = new TreeNode2(11);
		
		root1.left = node1;
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		
		MirrorOfTree mot = new MirrorOfTree();
		mot.Mirror(root1);
		System.out.println(root1.right.left.val);
		
	}

	// 递归的方式实现
	public void Mirror(TreeNode2 root) {
		if ((root == null) || (root.left == null && root.right == null)) {
			return;
		}
		
		TreeNode2 pTemp = root.left;
		root.left = root.right;
		root.right = pTemp;
		
		if (root.left != null) {
			Mirror(root.left);
		}
		
		if (root.right != null) {
			Mirror(root.right);
		}
	}
	
	// 循环的方式实现


}
