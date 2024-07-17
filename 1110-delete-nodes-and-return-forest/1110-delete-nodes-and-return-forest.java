class Solution {
   
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : toDelete) toDeleteSet.add(val);
        List<TreeNode> rst = new ArrayList<>();
        root = dfs(root, toDeleteSet, rst);
        if (root != null) rst.add(root);
        return rst;
    }
   
    private TreeNode dfs(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> rst) {
        if (node == null) return null;
        node.left = dfs(node.left, toDeleteSet, rst);
        node.right = dfs(node.right, toDeleteSet, rst);
       
        if (toDeleteSet.contains(node.val)) {
            if (node.left != null) rst.add(node.left);    
            if (node.right != null) rst.add(node.right);    
            return null;
        }
        return node;
    }
}
