class Solution {
    public Node copyRandomList(Node head) {
        // Check if the input linked list is null
        if (head == null) {
            return null;
        }

        // Step 1: Create a new copy of each node and insert it next to the original node
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Assign random pointers for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and copied linked lists
        Node original = head;
        Node copied = head.next;
        Node newHead = head.next;

        while (original != null) {
            original.next = original.next.next;
            if (copied.next != null) {
                copied.next = copied.next.next;
            }
            original = original.next;
            copied = copied.next;
        }

        return newHead;
    }
}
