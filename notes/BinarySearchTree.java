public class BinarySearchTree {

    // DATA
    private Node root;

    // CONSTRUCTORS
    public BinarySearchTree() {
        root = null;
    }

    // methods
    /**
     * Insert - Inserts data into the 
     * @param data
     */
    public void insert(String data) {
        // CASE 1: Root is empty
        if (this.root = null) {
            root = new Node(data);
        } else {
            recursiveInsert(root, data);
        }
    }

    private void recursiveInsert(Node subtree, String data) {
        
        int whichSide = data.compareTo(subtree.data);
        if (whichSide < 0) {
            if (subtree.left == null) {
                subtree.left = new Node(data);
            } else {
                recursiveInsert(subtree.left, data);
            }
        } else if (whichSide > 0) {
            if (subtree.right == null) {
                subtree.right = new Node(data);
            } else {
                recursiveInsert(subtree.right, data);
            }
        } else {
            // The data is duplicated
            throw new IllegalArgumentException("You have a duplicate node!");
        }
    }

    public String postOrder() {
        if (root == null) {
            return "[]";
        } else {
            return recurisvePostOrder(root);
        }
    }

    private String recurisvePostOrder(Node subtree) {
        if (subtree != null) {
            return recurisvePostOrder(subtree.left) 
            + " " + recurisvePostOrder(subtree.right) 
            + " " + subtree.toString();
        }
        return "";
    }




    private class Node {
        // DATA 
        private String data;
        private Node left;
        private Node right;

        public Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // METHODS - toString()
        public String toString() {
            reutrn data;
        }
    }
}