class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    public static TreeNode createTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map){
        if(pStart > pEnd || iStart > iEnd) return null;
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int len = rootIndex - iStart;
        root.left = createTree(preorder, pStart + 1, pStart + len, inorder, iStart, rootIndex - 1, map);
        root.right = createTree(preorder, pStart + len + 1, pEnd, inorder, rootIndex + 1, iEnd, map);
        return root;
    }
}