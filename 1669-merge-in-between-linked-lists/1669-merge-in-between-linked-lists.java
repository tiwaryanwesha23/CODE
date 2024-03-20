class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode begin = list1;
        ListNode cur = list1.next;
        int idx = 1;
        
        while (idx != a) {
            begin = begin.next;
            cur = cur.next;
            idx++;
        }
        
        ListNode end;
        while (idx != b) {
            cur = cur.next;
            idx++;
        }
        
        end = cur.next;
        cur.next = null;
        
        begin.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = end;
        
        return list1;
    }
}