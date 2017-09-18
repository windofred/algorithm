package cn.red.offer.second;

/**
 * 对称的二叉树
 * @author sala
 *
 */
public class Problem28 {
	
	public static void main(String[] args) {
		BinaryTreeNode node1 = new BinaryTreeNode(8);
		BinaryTreeNode node2 = new BinaryTreeNode(6);
		BinaryTreeNode node3 = new BinaryTreeNode(9);
		BinaryTreeNode node4 = new BinaryTreeNode(5);
		BinaryTreeNode node5 = new BinaryTreeNode(7);
		BinaryTreeNode node6 = new BinaryTreeNode(7);
		BinaryTreeNode node7 = new BinaryTreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node4.right = null;
		node5.left = node4.right = null;
		node6.left = node4.right = null;
		node7.left = node4.right = null;
		
		boolean symmetrical = isSymmetrical(node1);
		System.out.println(symmetrical);
		
	}
	
	public static boolean isSymmetrical(BinaryTreeNode root) {
		return isSymmetrical(root, root);
	}
	
	public static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
	}
	
}
