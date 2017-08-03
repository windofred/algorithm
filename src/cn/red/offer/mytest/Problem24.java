package cn.red.offer.mytest;

import java.util.Arrays;

/**
 * 
 * 树
 * 
 * 面试题24：二叉搜索树的后序遍历序列
 * 
 * 如果面试题是要求处理一棵二叉树的遍历序列，我们可以先找到二叉树的根结点，再基于根结点把整棵树的便利序列拆分成
 * 左子树对应的子序列和右子树对应的子序列，接下来再递归地处理这两个子序列。本面试题是应用这个思路。
 * 面试题6“重建二叉树”也是应用这个思路。
 * 
 * @author red
 *
 */
public class Problem24 {
	
	public static void main(String[] args) {
		Problem24 p24 = new Problem24();
		//int[] array = {5, 7, 6, 9, 11, 10, 8};
		int [] array = {7, 4, 6, 5};
		boolean b = p24.VerifySquenceOfBST(array);
		System.out.println(b);
	}

	public boolean VerifySquenceOfBST(int[] sequence) {
		
		if (sequence == null || sequence.length <= 0) {
			return false;
		}
		
		int root = sequence[sequence.length - 1];
		
		// 在二叉搜索树中，左子树结点的值小于根结点的值
		int i = 0;
		for (; i < sequence.length - 1; i++) {
			if (sequence[i] > root) {
				break;
			}
		}
		
		// 在二叉搜索树中，右子树结点的值大于根结点的值
		int j = i;
		for (; j < sequence.length - 1; j++) {
			if (sequence[j] < root) {
				return false;
			}
		}
		
		// 判断左子树是不是二叉搜索树
		boolean left = true;
		if (i > 0) {
			left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
		}
		
		// 判断右子树是不是二叉搜索树
		boolean right = true;
		if (i < sequence.length - 1) {
			VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length - 1));
		}
		
		return left && right;
	}

}
