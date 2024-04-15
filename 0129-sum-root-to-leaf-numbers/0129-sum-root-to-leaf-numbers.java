public class Solution {

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    private int sum(TreeNode root, int currentSum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return currentSum*10 + root.val;
        return sum(root.left, currentSum * 10 + root.val) + sum(root.right, currentSum * 10 + root.val);
    }
}