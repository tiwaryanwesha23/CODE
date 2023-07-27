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
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        if (root == null) { return max; }
        LinkedList<Long> l = new LinkedList<>();
        LinkedList<TreeNode> t = new LinkedList<>();
        l.offer((long)1);
        t.offer(root);
        while (!l.isEmpty()) {
            int n = l.size();
            long lo = 0;
            long hi = 0;
            for (int i = 0; i < n; i++) {
                long j = l.poll();
                TreeNode node = t.poll();
                if (lo == 0) { lo = j; }
                hi = j;
                if (node.left != null) {
                    l.offer((long)(j * 2));
                    t.offer(node.left);
                }
                if (node.right != null) {
                    l.offer((long)(j * 2 + 1));
                    t.offer(node.right);
                }
            }
            System.out.println(hi - lo + 1);
            max = Math.max(max, (int)(hi - lo + 1));
        }
        return max;
    }
}