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

        //O(N^2)time
//O(N)space
public TreeNode bstFromPreorder(int[] preorder) {
    TreeNode res = new TreeNode(preorder[0]);
    if(preorder.length == 1){
        return res;
    }
    for(int i = 1; i < preorder.length; i++){
        setNode(res,preorder[i]);
    }
    return res;
}

public void setNode(TreeNode node, int val){
    if(node.val < val){
        if(node.right == null){
            node.right = new TreeNode(val);
        }else{
          setNode(node.right,val);
        }
    }else {
         if(node.left == null){
            node.left = new TreeNode(val);
        }else{
          setNode(node.left,val);
        }
    }
}
    }
