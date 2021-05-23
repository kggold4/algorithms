package algorithms_1.practice;

public class Parking {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.getByIndex(9).next = list.getByIndex(4);

        System.out.println(hasLoop(list.getHead()));
        System.out.println(meetNode(list.getHead()));
        System.out.println(CircleStartNode(list.getHead()));
        System.out.println(lengthOfCircle(list.getHead()));
    }

    public static boolean hasLoop(NodeLinkedList head) {
        if(head == null) return false;

        NodeLinkedList a, b;
        a = b = head;
        while(true) {
            a = a.next;
            if(b.next.next != null) b = b.next.next;
            else return false;

            if(a == null || b == null) return false;

            if(a == b) return true;
        }
    }

    public static NodeLinkedList meetNode(NodeLinkedList head) {
        if(head == null) return null;

        NodeLinkedList a, b;
        a = b = head;
        while(true) {
            a = a.next;
            if(b.next.next != null) b = b.next.next;
            else return null;

            if(a == null || b == null) return null;

            if(a == b) return a;
        }
    }

    public static NodeLinkedList CircleStartNode(NodeLinkedList head) {
        if(head == null) return null;

        NodeLinkedList a, b;
        a = b = head;
        while(true) {
            a = a.next;
            if(b.next.next != null) b = b.next.next;
            else return null;

            if(a == null || b == null) return null;

            if(a == b) {
                a = head;
                while(true) {
                    a = a.next;
                    b = b.next;
                    if(a == b) return a;
                }
            }
        }
    }

    public static int lengthOfCircle(NodeLinkedList head) {
        if(head == null) return -1;

        NodeLinkedList a, b;
        a = b = head;
        while(true) {
            a = a.next;
            if(b.next.next != null) b = b.next.next;
            else return -1;

            if(a == null || b == null) return -1;

            if(a == b) {
                a = head;
                while(true) {
                    a = a.next;
                    b = b.next;
                    if(a == b) {
                        int count = 0;
                        while(true) {
                            b = b.next;
                            count++;
                            if(a == b) return count;
                        }
                    }
                }
            }
        }
    }
}
