package data_structures.binary_search_tree;

public class Node {
    Node left, right, parent;
    int data;
    public Node(int data) {
        this.data = data;
        this.left = this.right = this.parent = null;
    }
    public Node(int data, Node parent) {
        this.data = data;
        this.left = this.right = null;
        this.parent = parent;
    }
    public String toString() {
        return "" + this.data;
    }
}
