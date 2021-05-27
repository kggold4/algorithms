package data_structures.linkedlist;

public class Main {

    private static int NUMBER_OF_NODES = 24;

    public static void main(String[] args) {
        // testing reverse linked list function
        Node head = new Node();
        Node next = new Node();
        head.next = next;
        int i = 0;
        while(i < NUMBER_OF_NODES) {
            next.next = new Node();
            next = next.next;
            i++;
        }
        print_linked_list(head);
        Node new_head = Reverse.reverse_linked_list(head);
        print_linked_list(new_head);
    }

    private static void print_linked_list(Node node) {
        Node copy = node.copy();
        while(copy != null) {
            System.out.print(copy.data + " -> ");
            copy = copy.next;
        }
        System.out.println("null");
    }
}
