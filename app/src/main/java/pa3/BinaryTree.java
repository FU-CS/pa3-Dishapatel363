package pa3;

/**
 * A binary tree class that stores integers.
 * 
 * The integers are stored in the tree in the order they are added.
 * 
 * The integers are stored from top to bottom by level i.e. node is added to a new level only when the current level is full.
 * Within each level, the integers are stored from left to right.
 * In other words, the tree is always Balanced: depth of the left and right subtrees of every node differ by at most 1.
 * 
 */
public class BinaryTree {

    private Node root;

    /**
     * Constructs an empty binary tree.
     */
    public BinaryTree() {
        root = null; 
    }
    public static class Node {
        public int value; 
        public Node left; 
        public Node right; 
        
        public Node(int value){
            this.value = value;
            this.left = null; 
            this.right = null; 
        }
    }

    /**
     * Returns the level order traversal of the tree.
     * 
     * The level order traversal of a tree is the traversal of the tree by levels.
     * 
     * USE THE QUEUE from the pa3 package to implement this method. 
     * You are not allowed to use the built-in Java Queue.
     * 
     * Use the private helper method levelOrderTraversalHelper to implement this method.
     * 
     * @return the level order traversal of the tree.
     */
    public String levelOrderTraversal() {
        if (root == null){
            return "";
        }

        Queue queue = new Queue();
        queue.enqueue(root);
        String result = "";
        return levelOrderTraversalHelper(root, result);
        //return levelOrderTraversalHelper(root, null); 
    }

    /** 
     * Helper method for levelOrderTraversal that takes a node as an argument.
     */
    private String levelOrderTraversalHelper(Node node, String result) {
        Queue queue = new Queue();
        queue.enqueue(node);

        while (!queue.isEmpty()){
            Node current = queue.dequeue();
            
            result += current.value + " ";

            if (current.left != null){
                queue.enqueue(current.left);
            }
            if (current.right != null){
                queue.enqueue(current.right);
            }
        }
        return result; 
    }

    /**
     * Adds a value to the tree.
     * 
     * The value is added to the tree in the order it is added.
     * Use a variant of the level order traversal to add the value to the tree.
     * First time you find a null child, add the new node there.
     * 
     * @param value the value to add to the tree.
     */
    public void add(int value) {
        Node newNode = new Node(value);
        if (root == null){
            root = newNode;
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(root);

        // Traverse the tree level by level to find the first null child
        while (!queue.isEmpty()) {
            Node current = queue.dequeue();

            // Check the left child
            if (current.left == null) {
                current.left = newNode; // Add the new node as the left child
                return;
            } else {
                queue.enqueue(current.left); // Enqueue the left child for further traversal
            }

            // Check the right child
            if (current.right == null) {
                current.right = newNode; // Add the new node as the right child
                return;
            } else {
                queue.enqueue(current.right);
            }
        }
    }
    /** 
     * Inverts the tree: left and right children of each node are swapped.
     * 
     * For example, the tree:
     * 
     *     1
     *    / \
     *   2   3
     * 
     * is inverted to:
     * 
     *    1
     *   / \
     *  3   2
     * 
     * This inversion is done for all nodes in the tree.
     * 
     */
    public void invert() {
       root = invertHelper(root);
    }

    private Node invertHelper(Node node){
        if (node == null){
            return null; 
        }
        Node left = invertHelper(node.left);
        Node right = invertHelper(node.right);

        node.left = right; 
        node.right = left;

        return node;
    }

    public int getHeight() {
        return getHeightHelper(root);
    }

    /** Counts the height of the tree 
     *  Height is defined as the number of edges in the longest path from the root to a leaf node. 
     */
    private int getHeightHelper(Node node) {
        if (node == null){
            return -1; 
        }   
        
        int leftHeight = getHeightHelper(node.left);
        int rightHeight = getHeightHelper(node.right);

        return Math.max(leftHeight, rightHeight) +1; 
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        System.out.println(tree.levelOrderTraversal()); // Should print 1 2 3 4 5 6 7

        tree.invert();

        System.out.println(tree.levelOrderTraversal()); // Should print 1 3 2 7 6 5 4

        System.out.println(tree.getHeight()); // Should print 2
    }
}
