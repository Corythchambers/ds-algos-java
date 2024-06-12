package module1;

import org.junit.Test;
import static org.junit.Assert.*;

public class PenguinListTest {

    @Test
    public void testAddFirst() {
        PenguinList penguinList = new PenguinList();
        penguinList.addFirst(111, 1, 25);
        assertEquals(1, penguinList.listSize);
        assertEquals(111, penguinList.getFirst());
    }

    @Test
    public void testAddLast() {
        PenguinList penguinList = new PenguinList();
        penguinList.addLast(111, 1, 25);
        assertEquals(1, penguinList.listSize);
        assertEquals(111, penguinList.getLast());

        penguinList.addLast(222, 2, 30);
        assertEquals(2, penguinList.listSize);
        assertEquals(222, penguinList.getLast());
    }

    @Test
    public void testGetFirst() {
        PenguinList penguinList = new PenguinList(111, 1, 25);
        assertEquals(111, penguinList.getFirst());
    }

    @Test
    public void testGetLast() {
        PenguinList penguinList = new PenguinList(111, 1, 25);
        assertEquals(111, penguinList.getLast());

        penguinList.addLast(222, 2, 30);
        assertEquals(222, penguinList.getLast());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetFirstEmptyList() {
        PenguinList penguinList = new PenguinList();
        penguinList.getFirst();
    }

    @Test(expected = IllegalStateException.class)
    public void testGetLastEmptyList() {
        PenguinList penguinList = new PenguinList();
        penguinList.getLast();
    }

    @Test
    public void testTotalWeight() {
        PenguinList penguinList = new PenguinList();
        penguinList.addFirst(111, 1, 25);
        penguinList.addFirst(222, 2, 30);
        penguinList.addLast(333, 3, 35);
        assertEquals(6, penguinList.totalWeight());
    }

    @Test
    public void testRecursiveSize() {
        PenguinList penguinList = new PenguinList();
        assertEquals(0, penguinList.recursiveSize());

        penguinList.addFirst(111, 1, 25);
        assertEquals(1, penguinList.recursiveSize());

        penguinList.addFirst(222, 2, 30);
        penguinList.addLast(333, 3, 35);
        assertEquals(3, penguinList.recursiveSize());
    }

    @Test
    public void testEmptyList() {
        PenguinList penguinList = new PenguinList();
        assertEquals(0, penguinList.listSize);
        assertEquals(0, penguinList.totalWeight());
        assertEquals(0, penguinList.recursiveSize());
    }
}
