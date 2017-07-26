package cn.red.offer.problem6;

import java.util.Arrays;

/**
 * 重建二叉树:
 * 已知：前序遍历序列和中序遍历序列，来重建二叉树并返回根结点
 * 
 * 前序遍历序列：{1，2，4，7，3，5，6，8}
 * 中序遍历序列：{4，7，2，1，5，3，8，6}
 * 
 * 算法过程：
 *   在二叉树的前序遍历序列中，第一个数字总是树的根结点的值。但在中序遍历序列中，根结点的值在序列的中间，左子树的结点的值位于根结点的值的左边
 *   而右子树的结点的值位于根结点的值的右边。因此我们需要扫描中序遍历序列，才能找到根结点的值。
 *   
 *   前序遍历序列的第一个数字1就是根结点的值。扫描中序遍历序列，就能确定根结点的值的位置。根据中序遍历特点，在根结点的值1前面的3个数字都是
 *   左子树结点的值，位于1后面的数字都是右子树结点的值。
 *   
 *   由于在中序遍历中，有3个数字是左子树结点的值，因此左子树总共有3个左子结点。同样，在前序遍历的序列中，根结点后面的3个数字就是3个左子树
 *   结点的值，再后面的所有数字都是右子树结点的值。这样我们就在前序遍历和中序遍历两个序列中，分别找到了左右子树对应的子序列。
 *   
 *   既然我们已经分别找到了左、右子树的前序遍历序列和中序遍历序列，我们可以用同样的方法分别去构建左右子树。也就是说，接下来的事情可以用递归
 *   的方法去完成。
 *   
 * @author red
 *
 */
public class Problem6 {
	
	public static void main(String[] args) throws Exception {
		int[] preSort = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] inSort = {4, 7, 2, 1, 5, 3, 8, 6};
		BinaryTreeNode root = constructCore(preSort, inSort);
		System.out.println(root.value);
		
		int i = 5;
		int j = 10;
		System.out.println(i + ~j);
		
		
		
	}
	
	public static BinaryTreeNode constructCore(int[] preOrder, int[] inOrder) throws Exception {
		if (preOrder == null || inOrder == null) {
			return null;
		}
		
		if (preOrder.length != inOrder.length) {
			throw new Exception("长度不一样，非法的输入");
		}
		
		BinaryTreeNode root = new BinaryTreeNode();
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == preOrder[0]) {
				root.value = inOrder[i];
				System.out.println(root.value);
				// 递归调用constructCore()方法
				root.leftNode = constructCore(Arrays.copyOfRange(preOrder, 1, i+1), Arrays.copyOfRange(inOrder, 0, i));
				root.rightNode = constructCore(Arrays.copyOfRange(preOrder, i + 1, preOrder.length), Arrays.copyOfRange(inOrder, i + 1, inOrder.length));
			}
		}
		
		return root;
		
	}
	
}
