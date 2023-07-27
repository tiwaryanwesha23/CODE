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
    Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>(); // map<offset, Map<level, List<Val>>>
    int min = 0, max = 0;

    class Node {
        int offset, level, val;
        public Node (int offset, int level, int val) {
            this.offset = offset;
            this.level = level;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        return flattenMap();
    }
    
    private void dfs(TreeNode node, int offset, int level) {
        if (node == null) return;
        
        map.putIfAbsent(offset, new HashMap<>());
        map.get(offset).putIfAbsent(level, new ArrayList<>());
        map.get(offset).get(level).add(node.val);
        
        min = Math.min(min, offset);
        max = Math.max(max, offset);
        
        dfs(node.left, offset - 1, level + 1);
        dfs(node.right, offset + 1, level + 1);
    }
    
    private List<List<Integer>> flattenMap() {
        List<List<Integer>> rst = new ArrayList<>();
        for (int offset = min; offset <= max; offset++) {
            Map<Integer, List<Integer>> levelMap = map.get(offset);
            List<Integer> levels = new ArrayList<>(levelMap.keySet());
            List<Integer> list = new ArrayList<>();
            Collections.sort(levels);
            for (int level : levels) {
                Collections.sort(levelMap.get(level));
                list.addAll(levelMap.get(level));
            }
            rst.add(list);
        }
        return rst;
    }
}

