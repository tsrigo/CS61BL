public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    /* Creates an empty BST. Super() calls the constructor for BinaryTree (not in scope). */
    public BinarySearchTree() {
        super();
    }

    /* Creates a BST with root as ROOT. */
    public BinarySearchTree(TreeNode root) {
        super(root);
    }

    /* Returns true if the BST contains the given KEY. */
    public boolean contains(T key) {
        // TODO: YOUR CODE HERE
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return containsHelper(root, key);
    }

    public boolean containsHelper(TreeNode x, T key){
        if (x == null) return false;
        if (x.item == key) return true;

        int cmp = x.item.compareTo(key);
        if (cmp > 0){
            return containsHelper(x.left, key);
        }
        else{
            return containsHelper(x.right, key);
        }
    }
    /* Adds a node for KEY iff KEY isn't in the BST already. */
    public void add(T key) {
        // TODO: YOUR CODE HERE
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        root = addHelper(root, key);
    }

    public TreeNode addHelper(TreeNode x, T key){
        if (x == null){
            return new TreeNode(key);
        }
        int cmp = x.item.compareTo(key);
        if (cmp == 0) throw new IllegalArgumentException("This key is already existed!");
        else if (cmp > 0) x.left = addHelper(x.left, key);
        else x.right = addHelper(x.right, key);
        return x;
    }
    /* Deletes a node from the BST. 
     * Even though you do not have to implement delete, you 
     * should read through and understand the basic steps.
    */
    public T delete(T key) {
        TreeNode parent = null;
        TreeNode curr = root;
        TreeNode delNode = null;
        TreeNode replacement = null;
        boolean rightSide = false;

        while (curr != null && !curr.item.equals(key)) {
            if (curr.item.compareTo(key) > 0) {
                parent = curr;
                curr = curr.left;
                rightSide = false;
            } else {
                parent = curr;
                curr = curr.right;
                rightSide = true;
            }
        }
        delNode = curr;
        if (curr == null) {
            return null;
        }

        if (delNode.right == null) {
            if (root == delNode) {
                root = root.left;
            } else {
                if (rightSide) {
                    parent.right = delNode.left;
                } else {
                    parent.left = delNode.left;
                }
            }
        } else {
            curr = delNode.right;
            replacement = curr.left;
            if (replacement == null) {
                replacement = curr;
            } else {
                while (replacement.left != null) {
                    curr = replacement;
                    replacement = replacement.left;
                }
                curr.left = replacement.right;
                replacement.right = delNode.right;
            }
            replacement.left = delNode.left;
            if (root == delNode) {
                root = replacement;
            } else {
                if (rightSide) {
                    parent.right = replacement;
                } else {
                    parent.left = replacement;
                }
            }
        }
        return delNode.item;
    }
}
