package cn.red.offer.second;

import java.util.Arrays;

/**
 * 验证某一序列是否是某个搜索二叉树的后序遍历序列
 * @author red
 *
 */
public class Problem33 {
	
	public static void main(String[] args) {
		Problem33 p33 = new Problem33();
		int[] seq = {5, 7, 6, 9, 11, 10, 8};
		int[] seq2 = {7, 4, 6, 5};
		boolean b = p33.verify(seq2);
		System.out.println(b);
	}
	
	public boolean verify(int[] sequence) {
		// 边界条件的判定
		if (sequence == null || sequence.length <= 0) {
			return false;
		}
		
		int length = sequence.length;
		// 根节点
		int root = sequence[length - 1];
		
		// 在二叉搜索树中左子树节点的值小于根节点的值
		int i = 0;
		for (; i < length -1; i++) {
			if (sequence[i] > root) {
				break;
			}
		}
		
		// 在二叉搜索树中右子树节点的值大于根节点的值
		int j = i;
		for (; j < length - 1; j++) {
			if (sequence[j] < root) {
				return false;
			}
		}
		
		// 判断左子树是不是二叉搜索树
		boolean left = true;
		if (i > 0) {
			verify(Arrays.copyOfRange(sequence, 0, i));
		}
		// 判断右子树是不是二叉搜索树
		boolean right = true;
		if (i < length - 1) {
			verify(Arrays.copyOfRange(sequence, i, length - 1));
		}
		
		return left && right;
	}
	
}
