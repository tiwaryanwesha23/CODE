class Solution {
    private int res;
    public int distributeCoins(TreeNode root) {
        balance(root);
        return res;
    }
    private int balance(TreeNode node){
        if(node == null) return 0;
        else{
            int left = balance(node.left);
            int right = balance(node.right);
            res += Math.abs(left) + Math.abs(right);
            return node.val - 1 + left + right;
        }
    }
}