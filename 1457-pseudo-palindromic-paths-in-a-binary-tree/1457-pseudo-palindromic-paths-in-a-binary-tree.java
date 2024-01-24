/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        HashSet<Integer> seen = new HashSet<>();
        return helper(root, seen);
        
    }
    public int helper(TreeNode node, HashSet<Integer> set){
        if(node == null) return 0;
        if(set.contains(node.val)) set.remove(node.val);
        else set.add(node.val);
        if(node.left==null && node.right == null){
            if(set.size()<=1) return 1;
            else return 0;
        }
        
        return helper(node.left,(HashSet<Integer>)set.clone())+helper(node.right,(HashSet<Integer>)set.clone());
    }
}