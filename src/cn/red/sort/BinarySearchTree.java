package cn.red.sort;

/**
 * 
 * 树的基本术语：
 *     结点的度：结点拥有的字树的数目
 *     叶子：度为零的结点
 *     分支结点：度不为零的结点
 *     树的度：树中结点的最大的度
 *     
 *     层次：根结点的层次为1，其余结点的层次等于该结点的双亲结点的层次加1
 *     树的高度：树中结点的最大层次
 *     无序树：
 *     有序树：
 *     森林：
 * 
 * 二叉树的性质：
 *    性质1：二叉树第i层上的结点数目最多为：2{i - 1}(i >= 1)
 *    性质2：深度为k的二叉树至多有2{k} - 1个结点(k >= 1)
 *    性质3：包含n个结点的二叉树的高度至少为log2(n + 1)
 *    性质4：在任意一棵二叉树中，若终端结点的个数为n0，度为2的结点树为n2，则n0 = n2 + 1
 *    
 * 满二叉树：高度为h，并且由2{h} - 1个结点的二叉树，被称为满二叉树
 * 完全二叉树
 *     定义：一棵二叉树中，只有最下面两层结点的度可以小于2，并且最下一层的叶结点集中在靠左的若干位置上。这样的二叉树称为完全二叉树。
 *     特点：叶子结点只能出现在最下层和次下层，且最下层的叶子结点集中在树的左部。显然，一棵满二叉树必定是一棵完全二叉树，而完全二叉树未必是满二叉树。      
 * 
 * 二叉查找树的特点：
 *     (01) 若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 *     (02) 任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *     (03) 任意节点的左、右子树也分别为二叉查找树。
 *     (04) 没有键值相等的节点（no duplicate nodes）
 * 
 * @author red
 *
 */
public class BinarySearchTree {
	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40, 50, 60, 70};
		BinarySearchTree bst = new BinarySearchTree();
		int search = bst.binarySearch(array, 50);
		System.out.println("50所在的位置是：" + search);
	}
	
	public int binarySearch(int[] array, int key) {
		
		int left = 0;
		int right = array.length - 1;
		
		while (left <= right) {
			int middle = (left + right) / 2;
			if (array[middle] == key) {
				return middle;
			} else if (array[middle] > key) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		
		return -1;
	}
	
}
