package data_structures.linked_list;

public class Sort {

    /**
     * merge sort on linked list
     * @param head
     * @return
     */
    public static Node merge_sort_linked_list(Node head) {

        // base case
        if (head == null || head.next == null) return head;

        // get the middle of the list
        Node middle = get_middle(head);

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        Node left = merge_sort_linked_list(head);

        // Apply mergeSort on right list
        Node right = merge_sort_linked_list(middle.next);

        // Merge the left and right lists
        Node sortedlist = sorted_merge(left, right);
        return sortedlist;
    }

    /**
     * return the middle node of a linked list
     * @param head
     * @return
     */
    private static Node get_middle(Node head) {

        // base case
        if(head == null) return head;

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * sorted merge on two given nodes
     * @param a
     * @param b
     * @return
     */
    private static Node sorted_merge(Node a, Node b) {
        Node result = null;

        // base cases
        if(a == null) return b;
        if(b == null) return a;

        if (a.data <= b.data) {
            result = a;
            result.next = sorted_merge(a.next, b);
        } else {
            result = b;
            result.next = sorted_merge(a, b.next);
        }
        return result;
    }
}
