class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        if(head.val == root.val) 
        { boolean temp = startsWith(head, root);
            if(temp) return true;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean startsWith(ListNode head, TreeNode node){
        if(head == null) return true;
        if(node == null) return false;
        if(head.val != node.val) return false;
        return startsWith(head.next, node.left)||startsWith(head.next, node.right);
    }
}