package cn.red.offer;

import java.util.Arrays;

/**
 * 验证某一序列是否是某一二叉树的后续遍历序列
 * 
 * 7月18日调试没通过
 * @author red
 *
 */
public class VerifyPostOrderOfBST {

	public static void main(String[] args) {
		VerifyPostOrderOfBST tmp = new VerifyPostOrderOfBST();
		int[] sequence = {5, 7, 6, 9, 11, 10, 8};
		int[] sequence2 = {7, 4, 6, 9};
		int[] sequence3 = {4,6,12,8,16,14,10};
		boolean b = tmp.VerifySquenceOfBST(sequence3);
		System.out.println(b);
	}

	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length <= 0) {
			return false;
		}
		int length = sequence.length;
		int root = sequence[length - 1];
		
		// 在二叉搜索树中，左子树结点的值均小于根结点的值
		int cut = 0;
		for (int i = 0; i < length - 1; i++) {
			if (sequence[i] > root) {
				cut++;
			}
			break;
		}
		
		if (cut == 0) {
			VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, length - 1)); 
		} else {
			// 在二叉搜索树中，右子树结点的值均大于根结点的值
			for (int j = cut; j < length - 1; j++) {
				if (sequence[j] < root) {
					return false;
				}
			}
		}
		
		// 递归判断左子树是不是二叉搜索树
		boolean left = true;
		if (cut > 0) {
			left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, cut));
		}
		
		// 递归判断右子树是不是二叉搜索树
		boolean right = true;
		if (cut < length - 1) {
			right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, cut, length - 1));
		}
		
		return left && right;
	}

}
