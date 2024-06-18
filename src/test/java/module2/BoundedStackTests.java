package module2;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoundedStackTests {

    @Test
    public void testCreateStack() {
        BoundedStack<Integer> boundedStack = new BoundedStack<>();
        boundedStack.push(1);
        assertEquals((Integer) 1, boundedStack.pop());
        assertTrue(boundedStack.isEmpty());
    }

    @Test
    public void testPush()  {
        BoundedStack<Integer> boundedStack = new BoundedStack<>();
        boundedStack.push(2);
        assertEquals((Integer) 2, boundedStack.pop());
        assertTrue(boundedStack.isEmpty());
    }

    @Test
    public void TestPushOverflow() {
        BoundedStack<Integer> boundedStack = new BoundedStack<>();
        for (int i = 0; i <= 55; i++) {
            boundedStack.push(i);
        }
        assertEquals(50, boundedStack.getSize());
        assertEquals((Integer)  55, boundedStack.pop());
    }
}
