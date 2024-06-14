package module2;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyStackTests {

    @Test
    public void testPush() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        assertEquals(1, myStack.pop());
    }

    @Test
    public void testPushSeveral() {
        MyStack myStack = new MyStack();
        for (int i = 0; i <= 5; i++) {
            myStack.push(i);
        }
        assertEquals(5, myStack.pop());
    }

    @Test
    public void testPop() {
        MyStack myStack = new MyStack();
        for (int i = 0; i <= 5; i++) {
            myStack.push(i);
        }
        for (int i = 5; i >= 0; i--) {
            assertEquals(i, myStack.pop());
        }
    }

    @Test
    public void testPopEmptyStack() {
        MyStack myStack = new MyStack();
        assertEquals(-1, myStack.pop());
    }
}
