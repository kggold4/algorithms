package data_structures.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeDS {
    private Node root;

    public BinarySearchTreeDS() {
        this.root = null;
    }

    public BinarySearchTreeDS(Node root) {
        this.root = root;
    }

    public void add(int data) { this.root = add(data, null, this.root); }
    private Node add(int data, Node parent, Node node) {
        if(node == null) return new Node(data, parent);
        if(data < node.data) node.left = add(data, node, node.left);
        else node.right = add(data, node, node.right);
        return node;
    }

    public void remove(int data) { this.root = remove(data, this.root); }
    private Node remove(int data, Node node) {
        if(data < node.data) node.left = remove(data, node.left);
        else if(data > node.data) node.right = remove(data, node.left);
        else {

            // no child
            if(node.left == null && node.right == null) return null;

            // one child
            if(node.right == null) return node.left;
            else if(node.left == null) return node.right;

            // two child
            else {
                int minValue = min(node.right);
                node.data = minValue;
                node.right = remove(minValue, node.right);
            }
        }
        return node;
    }

    public int min() {
        if(isEmpty()) return -1;
        return min(this.root);
    }
    private int min(Node node) {
        if(node.left != null) return min(node.left);
        return node.data;
    }
    private Node minNode(Node node) {
        if(node.left != null) return minNode(node.left);
        return node;
    }

    public int max() {
        if(isEmpty()) return -1;
        return max(this.root);
    }
    private int max(Node node) {
        if(node.right != null) return max(node.right);
        return node.data;
    }
    private Node maxNode(Node node) {
        if(node.right != null) return maxNode(node.right);
        return node;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int size() { return size(this.root); }
    private int size(Node node) {
        if(node == null) return 0;
        return size(node.left) + size(node.right) + 1;
    }

    public void preorder() { preorder(this.root); }
    private static void preorder(Node node) {
        if(node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder() { inorder(this.root); }
    private static void inorder(Node node) {
        if(node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public void postorder() { postorder(this.root); }
    private static void postorder(Node node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void printLevels() { printLevels(this.root); }
    public static void printLevels(Node root) {
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int in_levels = q.size();
            while(in_levels > 0) {
                Node node = q.poll();
                System.out.println(node.data + " ");
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                in_levels--;
            }
            System.out.println();
        }
    }

    public Node successor(Node node) {
        if(node.right != null) {
            return minNode(node.right);
        }

        Node parent = node.parent;
        while(parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public Node successor(Node root, Node node) {
        if(node.right != null) {
            return minNode(node.right);
        }

        Node suc = null;
        while(root != null) {
            if(node.data < root.data) {
                suc = root;
                root = root.left;
            } else if(node.data > root.data) {
                root = root.right;
            } else break;
        }
        return suc;
    }

    public Node predecessor(Node node) {
        if(node.left != null) {
            return minNode(node.left);
        }

        Node parent = node.parent;
        while(parent != null && node == parent.left) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }
}
