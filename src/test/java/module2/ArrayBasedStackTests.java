package module2;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayBasedStackTests {

    @Test
    public void testCreateStack() {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        assertEquals(0, arrayBasedStack.size());
    }

    @Test
    public void testPush() {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        arrayBasedStack.push(1);
        assertEquals(1, arrayBasedStack.size());
    }

    @Test
    public void testPushResize() {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        for (int i = 0; i < 10; i++) {
            arrayBasedStack.push(i);
        }
        assertEquals(10, arrayBasedStack.size());
    }

    @Test
    public void testPop() {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        for (int i = 0; i <= 5; i++) {
            arrayBasedStack.push(i);
        }
        for (int i = 5; i >= 0; i--) {
            assertEquals(i, arrayBasedStack.pop());
        }
    }

    @Test
    public void testPopEmptyStack() {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        assertEquals(-1, arrayBasedStack.pop());
    }

    @Test
    public void testPeek() {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        arrayBasedStack.push(1);
        assertEquals(1, arrayBasedStack.peek());
        assertEquals(1, arrayBasedStack.size());
        assertEquals(1, arrayBasedStack.pop());
    }

    @Test
    public void testPeekEmptyStack() {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        assertEquals(-1, arrayBasedStack.peek());
    }

    @Test
    public void testIsEmpty() {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        assertTrue(arrayBasedStack.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        arrayBasedStack.push(1);
        assertFalse(arrayBasedStack.isEmpty());
    }

    @Test
    public void testIsEmptyPop() {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        arrayBasedStack.push(1);
        assertFalse(arrayBasedStack.isEmpty());
        arrayBasedStack.pop();
        assertTrue(arrayBasedStack.isEmpty());
    }
}
