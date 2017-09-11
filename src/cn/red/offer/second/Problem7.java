package cn.red.offer.second;

import java.util.Arrays;

/**
 * 重建二叉树
 * @author red
 *
 */

public class Problem7 {
	
	public static void main(String[] args) {
		Problem7 p7 = new Problem7();
		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
		BinaryTreeNode node = p7.reBuildBinaryTree(pre, in);
		System.out.println(node.right.right.left.val);
	}
	
	public BinaryTreeNode reBuildBinaryTree(int[] pre, int[] in) {
		if (pre == null | in == null) {
			return null;
		}
		
		BinaryTreeNode root = null;
		
		int[] preLeft = null;
		int[] preRight = null;
		int[] inLeft = null;
		int[] inRight = null;
		
		if (pre.length != 0 && in.length != 0) {
			root = new BinaryTreeNode(pre[0]);
			for (int i = 0; i < in.length; i++) {
				if (root.val == in[i]) {
					preLeft = Arrays.copyOfRange(pre, 1, i + 1);
					preRight = Arrays.copyOfRange(pre, i + 1, pre.length);
					inLeft = Arrays.copyOfRange(in, 0, i);
					inRight = Arrays.copyOfRange(in, i + 1, in.length);
				}
			}
			
			root.left = reBuildBinaryTree(preLeft, inLeft);
			root.right = reBuildBinaryTree(preRight, inRight);
		}
		
		return root;
	}
	
	
}
