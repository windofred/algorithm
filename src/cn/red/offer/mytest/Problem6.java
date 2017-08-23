package cn.red.offer.mytest;

import org.junit.Test;

/**
 * 
 * 树
 * 
 * 面试题6：重建二叉树
 * 已知：先序序列 中序序列
 * 
 * @author red
 *
 */

class TreeNode2 {
	int value;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2(int value) {
		this.value = value;
	}
}

public class Problem6 {
	
	@Test
	public void test1() {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		// 重建树的根节点
		TreeNode2 node = reConstructBinaryTree(pre, in);
		System.out.println(node.value);
	}

	public TreeNode2 reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length != in.length || pre.length < 1) {
			return null;
		}	
		return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	/**
	 * 
	 * @param pre 先序序列
	 * @param ps 先序起始位置
	 * @param pe 先序终止位置
	 * @param in 中序序列
	 * @param is 中序起始位置
	 * @param ie 中序终止位置
	 * @return
	 */
	private TreeNode2 construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
		if (ps > pe) {
			return null;
		}
		
		int value = pre[ps];
		int index = is;
		while (index <= ie && in[index] != value) {
			// 根结点在中序序列中的索引
			index++;
		}
		
		if (index > ie) {
			throw new RuntimeException("invalid input" + index);
		}
		// 构建重建二叉树的根结点
		TreeNode2 node = new TreeNode2(0);
		node.value = value;
		// 递归重建左子树和右子树
		// 前序序列的左子树：2 4 7(ps + 1, ps + index -is)
		// 前序序列的右子树：3 5 6 8(ps + index -is + 1, pe)
		// 中序序列的左子树：4 7 2(is, index - 1)
		// 中序序列的右子树：5 3 8 6(index + 1, ie)
		node.left = construct(pre, ps + 1, ps + index - is, in, is, index - 1);
		node.right = construct(pre, ps + index - is + 1, pe, in, index + 1, ie);
		return node;
	}
	
}
