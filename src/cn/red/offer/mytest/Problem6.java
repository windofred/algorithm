package cn.red.offer.mytest;

import org.junit.Test;

/**
 * 
 * 树
 * 
 * 面试题6：重建二叉树
 * 
 * @author red
 *
 */

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;

	TreeNode(int value) {
		this.value = value;
	}
}

public class Problem6 {
	
	@Test
	public void test1() {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode node = reConstructBinaryTree(pre, in);
		System.out.println(node.right.value);
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length != in.length || pre.length < 1) {
			return null;
		}	
		return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
		if (ps > pe) {
			return null;
		}
		
		int value = pre[ps];
		int index = is;
		while (index <= ie && in[index] != value) {
			index++;
		}
		
		if (index > ie) {
			throw new RuntimeException("invalid input" + index);
		}
		TreeNode node = new TreeNode(0);
		node.value = value;
		node.left = construct(pre, ps + 1, ps + index - is, in, is, index - 1);
		node.right = construct(pre, ps + index - is + 1, pe, in, index + 1, ie);
		return node;
	}
	
}
