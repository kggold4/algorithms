package data_structures.linkedlist;

public class Reverse {

    /**
     * reverse_linked_list
     * @param head
     * @return
     */
    public static Node reverse_linked_list(Node head) {

        // base case
        if(head == null || head.next == null) {
            return head;
        }

        Node curr = head.copy();
        Node prev = null, next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
