/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        ListNode nodeFront = node;
        ListNode mNode = node.next; //This is the mth node and will be the tail of reversed list. Reserve it for post-linking

        node = node.next;
        for (int i = m; i <= n; i++) {
            ListNode temp = node.next;
            node.next = nodeFront.next;
            nodeFront.next = node;
            node = temp;
        }
        // the previous mth node is now at tail, and should link the very next node in the list.
        mNode.next = node;

        return dummy.next;
    }
}

