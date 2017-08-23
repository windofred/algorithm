package cn.red.offer.second;

/**
 * 树的子结构
 * 测试未通过
 * @author red
 *
 */

class BinaryTreeNode_26 {
	double val;
	BinaryTreeNode_26 left = null;
	BinaryTreeNode_26 right = null;
	
	public BinaryTreeNode_26(double val) {
		this.val = val;
	}
}

public class Problem26 {
	
	public static void main(String[] args) {
		BinaryTreeNode_26 first1 = new BinaryTreeNode_26(8);
		BinaryTreeNode_26 second1 = new BinaryTreeNode_26(8);
		BinaryTreeNode_26 third1 = new BinaryTreeNode_26(7);
		BinaryTreeNode_26 forth1 = new BinaryTreeNode_26(9);
		BinaryTreeNode_26 fifth1 = new BinaryTreeNode_26(2);
		BinaryTreeNode_26 sixth1 = new BinaryTreeNode_26(4);
		BinaryTreeNode_26 seventh1 = new BinaryTreeNode_26(7);
		
		first1.left = second1;
		first1.right = third1;
		second1.left = forth1;
		second1.right = fifth1;
		third1.left = third1.right = null;
		forth1.left = forth1.right = null;
		fifth1.left = sixth1;
		fifth1.right = seventh1;
		sixth1.left = sixth1.right = null;
		seventh1.left = seventh1.right = null;
		
		BinaryTreeNode_26 first2 = new BinaryTreeNode_26(8);
		BinaryTreeNode_26 second2 = new BinaryTreeNode_26(9);
		BinaryTreeNode_26 third2 = new BinaryTreeNode_26(2);
		
		first2.left = second2;
		first2.right = third2;
		second2.left = second2.right = null;
		third2.left = third2.right = null;
		
		Problem26 p26 = new Problem26();
		boolean b = p26.hasSubTree(first1, first2);
		System.out.println(b);
	}
	
	public boolean hasSubTree(BinaryTreeNode_26 pRoot1, BinaryTreeNode_26 pRoot2) {
		
		boolean result = false;
		
		if (pRoot1 != null && pRoot2 != null) {
			if (equal(pRoot1.val, pRoot2.val)) {
				result = doesTree1HaveTree2(pRoot1, pRoot2);
			}
			if (!result) {
				result = hasSubTree(pRoot1.left, pRoot2);
			}
			if (!result) {
				result = hasSubTree(pRoot1.right, pRoot2);
			}
		}
		
		return result;
	}
	
	public boolean doesTree1HaveTree2(BinaryTreeNode_26 pRoot1, BinaryTreeNode_26 pRoot2) {
		
		if (pRoot1 == null) {
			return false;
		}
		if (pRoot2 == null) {
			return true;
		}
		if (!equal(pRoot1.val, pRoot2.val)) {
			return false;
		}
		
		return doesTree1HaveTree2(pRoot1.left, pRoot2.left) && doesTree1HaveTree2(pRoot1.right, pRoot2.right);
		
	}

	// 判断两个double数是否相等
	public boolean equal(double num1, double num2) {
		if ((num1 - num2 < 0.0000001) && (num1 - num2 > -0.0000001)) {
			return true;
		} else {
			return false;
		}
	}
	
}
