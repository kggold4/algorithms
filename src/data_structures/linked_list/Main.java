package data_structures.linked_list;

public class Main {

    private static int NUMBER_OF_NODES = 24;

    public static void main(String[] args) {
        // testing reverse linked list function
        Node head1 = new Node();
        Node next1 = new Node();
        head1.next = next1;
        int i = 0;
        while(i < NUMBER_OF_NODES) {
            next1.next = new Node();
            next1 = next1.next;
            i++;
        }
        print_linked_list(head1);
        Node new_head1 = Reverse.reverse_linked_list(head1);
        print_linked_list(new_head1);

        // testing sort linked list function
        Node head2 = new Node(3);
        head2.next = new Node(2);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(1);
        head2.next.next.next.next.next = new Node(6);
        print_linked_list(head2);
        Node new_head2 = Sort.merge_sort_linked_list(head2);
        print_linked_list(new_head2);

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
