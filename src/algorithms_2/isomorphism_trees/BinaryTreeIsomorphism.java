package algorithms_2.isomorphism_trees;

public class BinaryTreeIsomorphism {
    // r1 and r2 are the roots of two binary trees
    boolean isIsomorphic(Node r1, Node r2) {
        if(r1 == null && r2 == null) return true;
        if((r1 == null || r2 == null) || (r1.data != r2.data)) return false;
        return (isIsomorphic(r1.left, r2.left) && isIsomorphic(r1.right, r2.right)) ||
               (isIsomorphic(r1.left, r2.right) && isIsomorphic(r1.right, r2.left));
    }
}
