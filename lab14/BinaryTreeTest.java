import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinaryTreeTest {
    @Test
    public void treeFormatTest() {
        BinarySearchTree<String> x = new BinarySearchTree<String>();
        x.add("C");
        x.add("A");
        x.add("E");
        x.add("B");
        x.add("D");

        assertTrue(x.contains("B"));
        assertFalse(x.contains("hhh"));

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outContent));
        BinaryTree.print(x, "x");
        System.setOut(oldOut);
        assertEquals("x in preorder\r\nC A B E D \r\nx in inorder\r\nA B C D E \r\n\r\n".trim(),
                     outContent.toString().trim());
    }

    @Test
    public void testNum() {
        BinarySearchTree<Integer> x = new BinarySearchTree<>();
        x.add(1);
        x.add(4);
        x.add(9);
        x.add(5);
        x.add(3);
        x.add(6);

        assertTrue(x.contains(9));
        assertFalse(x.contains(100));

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outContent));
        BinaryTree.print(x, "x");
        System.setOut(oldOut);
        assertEquals("x in preorder\r\n1 4 3 9 5 6 \r\nx in inorder\r\n1 3 4 5 6 9 \r\n\r\n".trim(),
                outContent.toString().trim());
    }
}