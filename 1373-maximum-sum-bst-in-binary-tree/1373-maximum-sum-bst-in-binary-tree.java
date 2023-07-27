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
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        if(root == null){
            return ans;
        }
        
        isBST(root);
        
        return ans;
    }
    // int[]{sign, sum, min, max}
    private int[] isBST(TreeNode cur){
        int curSign = 1, curVal = cur.val, curMin = cur.val, curMax = cur.val;
         
        int[] l = new int[4], r = new int[4];
        if(cur.left != null){
            l = isBST(cur.left);
            curSign *= l[0];
            curMin = l[2];
        } 
        if(cur.right != null){
            r = isBST(cur.right);
            curSign *= r[0];
            curMax = r[3];
        }
        
        if(cur.left != null && l[3] >= cur.val || cur.right != null && r[2] <= cur.val){
            curSign = 0;
        }
        
        if(curSign == 1){
            curVal += l[1] + r[1];
            ans = Math.max(ans, curVal);
        }
        return new int[]{curSign, curVal, curMin, curMax};
    }
}