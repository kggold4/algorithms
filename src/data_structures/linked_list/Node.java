package data_structures.linked_list;

public class Node {

    static int data_counter = 0;

    int data;
    Node next; // pointer to the next node

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this.data = data_counter++;
        this.next = null;
    }

    public Node copy() {
        Node copy = new Node(this.data);
        copy.next = this.next;
        return copy;
    }
}
