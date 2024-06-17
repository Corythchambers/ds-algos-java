package module2;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class GenericStackTests {

    @Test
    public void testCreateClassInt() {
        GenericStack<Integer> genericStack = new GenericStack<>(1);
        assertEquals((Integer) 1, genericStack.pop());
        assertNull(genericStack.pop());
    }

    @Test
    public void testPushInt() {
        GenericStack<Integer> genericStack = new GenericStack<>(1);
        genericStack.push(2);
        assertEquals((Integer) 2, genericStack.pop());
        assertEquals((Integer) 1, genericStack.pop());
    }

    @Test
    public void testCreateClassString() {
        GenericStack<String> genericStack = new GenericStack<>("yes");
        assertEquals("yes", genericStack.pop());
        assertTrue(genericStack.isEmpty());
    }

    @Test
    public void testPushString() {
        GenericStack<String> genericStack = new GenericStack<>("yes");
        genericStack.push("no");
        assertEquals("no", genericStack.pop());
        assertEquals("yes", genericStack.pop());
    }

    @Test
    public void testPeekString() {
        GenericStack<String> genericStack = new GenericStack<>("yes");
        genericStack.push("no");
        assertEquals("no", genericStack.peek());
    }
}
