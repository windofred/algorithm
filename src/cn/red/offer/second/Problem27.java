package cn.red.offer.second;

/**
 * 二叉树的镜像
 * @author red
 *
 */

class BinaryTreeNode_27 {
	int val;
	BinaryTreeNode_27 left = null;
	BinaryTreeNode_27 right = null;
	
	public BinaryTreeNode_27(int val) {
		this.val = val;
	}
}

public class Problem27 {
	
	public static void main(String[] args) {
		BinaryTreeNode_27 first = new BinaryTreeNode_27(8);
		BinaryTreeNode_27 second = new BinaryTreeNode_27(6);
		BinaryTreeNode_27 third = new BinaryTreeNode_27(10);
		first.left = second;
		first.right = third;
		second.left = second.right = null;
		third.left = third.right = null;
		
		Problem27 p27 = new Problem27();
		p27.mirrior(first);
		
		System.out.println(first.left.val);
	}
	
	public void mirrior(BinaryTreeNode_27 pNode) {
		if (pNode == null) {
			return;
		}
		if (pNode.left == null && pNode.right == null) {
			return;
		}
		BinaryTreeNode_27 pTemp = pNode.left;
		pNode.left = pNode.right;
		pNode.right = pTemp;
		
		if (pNode.left != null) {
			mirrior(pNode.left);
		}
		if (pNode.right != null) {
			mirrior(pNode.right);
		}
		
	}
	
}
