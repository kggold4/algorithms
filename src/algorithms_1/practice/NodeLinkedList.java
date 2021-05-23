package algorithms_1.practice;

/**
 * Definition of Node in the linked list
 * @author Anna
 *
 */
public class NodeLinkedList {
    public int data;
    public NodeLinkedList next;
 
    public NodeLinkedList(int data) {
        this.data = data;
        this.next = null;
    }

    public String toString() { return "" + this.data; }
}
