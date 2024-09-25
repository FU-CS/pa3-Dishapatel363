package pa3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    // Add tests for the Queue class here

    @Test
    public void testEnqueue() {
        Queue queue = new Queue();
        //i dont know but it was giving me error and debugging suggested that since node is nested inside BinaryTree
        //so i have to change every mention of Node to BinaryTree.Node (still have question on this)
        BinaryTree.Node node1 = new BinaryTree.Node(4);
        BinaryTree.Node node2 = new BinaryTree.Node(5);
        queue.enqueue(node1);
        queue.enqueue(node2);
        assertEquals(node1, queue.dequeue());
    }

}
