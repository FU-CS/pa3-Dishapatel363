
package pa3;

/**
 * A queue of nodes.
 */
public class Queue {

    //debugger said that node is nested i have to replace it with BinaryTree.Node
    private BinaryTree.Node head;
    private BinaryTree.Node tail;

    /** 
     * Constructs an empty queue.
     */
    public Queue() {
        head = null; 
        tail = null;         
    }

    /**
     * Adds a node to the queue.
     * @param node
     */
    public void enqueue(BinaryTree.Node node) {
        //QueueNode newNode = new QueueNode(node);
        if (tail == null){
            head = node;
            tail = node;
        }
        //rear = newNode; 
        else {
            tail.right = node;
            tail = node;  
        }
        
    }

    /**
     * Removes and returns the node at the front of the queue.
     * @return the node at the front of the queue.
     */
    public BinaryTree.Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        BinaryTree.Node dequeuedNode = head; 
        head = head.right; 

        if (head == null) {
            tail = null;
        }

        return dequeuedNode; 
    }

    /**
     * Returns true if the queue is empty.
     * @return true if the queue is empty.
     */
    public boolean isEmpty() {
        return head == null; 
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        BinaryTree.Node node1 = new BinaryTree.Node(4);
        BinaryTree.Node node2 = new BinaryTree.Node(4);
        queue.enqueue(node1);
        queue.enqueue(node2);
        System.out.println(queue.dequeue().value); // Should print 4
    }
    
}
