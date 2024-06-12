package module2;

import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusListTests {

    @Test
    public void testAddLast() {
        WalrusList walrusList = new WalrusList();
        walrusList.addLast(1, 100, 10);
        assertEquals(1, walrusList.size());
        assertEquals(1, walrusList.getFirstId());
        assertEquals(10, walrusList.getFirstTuskLength());
        assertEquals(100, walrusList.getFirstWeight());
    }

    @Test
    public void testAddFirst() {
        WalrusList walrusList = new WalrusList();
        walrusList.addLast(1, 100, 10);
        walrusList.addLast(2, 200, 20);
        walrusList.addFirst(3, 300, 30);
        assertEquals(3, walrusList.size());
        assertEquals(3, walrusList.getFirstId());
        assertEquals(30, walrusList.getFirstTuskLength());
        assertEquals(300, walrusList.getFirstWeight());
    }

    @Test
    public void testGetTotalWeight() {
        WalrusList walrusList = new WalrusList();
        walrusList.addLast(1, 100, 10);
        walrusList.addLast(2, 200, 20);
        walrusList.addLast(3, 300, 30);
        assertEquals(600, walrusList.getTotalWeight());
    }

    @Test
    public void testResizing() {
        WalrusList walrusList = new WalrusList();
        walrusList.addLast(1, 100, 10);
        walrusList.addLast(2, 200, 20);
        walrusList.addLast(3, 300, 30);
        walrusList.addLast(4, 400, 40);
        walrusList.addLast(5, 500, 50);
        assertEquals(5, walrusList.size());
    }
}
