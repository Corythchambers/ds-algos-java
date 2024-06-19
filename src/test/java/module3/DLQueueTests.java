package module3;

import org.junit.Test;
import static org.junit.Assert.*;

public class DLQueueTests {

    @Test
    public void createDLQueue() {
        DLQueue atm = new DLQueue(15.5F);
        assertEquals(15.5F, atm.peek(), 0.000001);
        assertEquals(1, atm.size());
    }

    @Test
    public void enQueueDLQueue() {
        DLQueue atm = new DLQueue(15.5F);
        for (int i = 0; i <= 5; i++) {
            atm.enQueue(5.25F + i);
        }
        assertEquals(7, atm.size());
        assertEquals(15.5F, atm.peek(), 0.000001);
    }

    @Test
    public void dequeueDLQueue() {
        DLQueue atm = new DLQueue(15.5F);
        for (int i = 0; i <= 5; i++) {
            atm.enQueue(5.25F + i);
        }
        for (int i = 0; i <= 6; i++) {
            atm.deQueue();
        }
        assertEquals(0, atm.size());
        assertEquals(-1.0F, atm.peek(), 0.000001);
    }

    @Test
    public void dequeueEmptyQueue() {
        DLQueue atm = new DLQueue(15.5F);
        for (int i = 0; i <= 3; i++) {
            atm.deQueue();
        }
        assertEquals(0, atm.size());
    }

    @Test
    public void enqueueEmptyQueue() {
        DLQueue atm = new DLQueue(15.5F);
        for (int i = 0; i <= 3; i++) {
            atm.deQueue();
        }
        assertEquals(0, atm.size());
        atm.enQueue(5.25F);
        assertEquals(1, atm.size());
        assertEquals(5.25F, atm.peek(), 0.000001);
    }

    @Test
    public void enqueueQueueOneItem() {
        DLQueue atm = new DLQueue(15.5F);
        for (int i = 0; i <= 3; i++) {
            atm.deQueue();
        }
        assertEquals(0, atm.size());
        for (int i = 0; i < 3; i++) {
            atm.enQueue(5.25F + i);
        }
        assertEquals(3, atm.size());
        assertEquals(5.25F, atm.peek(), 0.000001);
    }



}
