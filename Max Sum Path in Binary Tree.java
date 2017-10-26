/*
Max Sum Path in Binary Tree 

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public long ans = (long)Integer.MIN_VALUE;
    
	public int maxPathSum(TreeNode root) {
	    if(root == null)
			return 0;
		Util(root);
		return (int)ans;
	}
	
	public long Util(TreeNode node){
		long a = (long)node.val;
		long l = node.left != null ? Util(node.left) : (long)Integer.MIN_VALUE;
		long r = node.right != null ? Util(node.right) : (long)Integer.MIN_VALUE;
		long returnval = Math.max(Math.max(a+l , a+r) , a);
		ans = Math.max(ans , Math.max(returnval , a+l+r));
		return returnval;
	}
}
