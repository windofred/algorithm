package cn.red.offer.mytest;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * 树
 * 
 * 面试题25：二叉树中和为某一值得路径
 * 
 * @author red
 *
 */

class TreeNode3 {
	int val;
	TreeNode3 left;
	TreeNode3 right;
	
	public TreeNode3(int val) {
		this.val = val;
	}
}
public class Problem25 {
	
	public static void main(String[] args) {
		
	}

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode3 root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return pathList;
        Stack<Integer> stack=new Stack<Integer>();
        FindPath(root,target,stack,pathList );
        return pathList;
         
    }
    private void FindPath(TreeNode3 root, int target, Stack<Integer> path, ArrayList<ArrayList<Integer>> pathList) {
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            if(root.val==target){
                ArrayList<Integer> list=
                        new ArrayList<Integer>();
                for(int i:path){
                    list.add(new Integer(i));
                }
                list.add(new Integer(root.val));
                pathList.add(list);
            }
        }
        else{
            path.push(new Integer(root.val));
            FindPath(root.left, target-root.val, path, pathList);
            FindPath(root.right, target-root.val, path,  pathList);
            path.pop();
        }
         
    }

}
