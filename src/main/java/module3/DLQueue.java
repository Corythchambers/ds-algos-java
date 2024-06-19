package module3;

public class DLQueue {
    class IntNode {
        public float item;
        public IntNode next;
        public IntNode prev;
        private IntNode(float i, IntNode n) {
            item = i;
            next = n;
            prev = null;
        }
    }
    private IntNode head;
    private IntNode tail;
    private int size = 1;
    public DLQueue(float x) {
        head = new IntNode(x, null);
        tail = head;
    }

    public void deQueue() {
        if (head != null) {
            head = head.next;
            size--;
        }
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
    }

    public void enQueue(float x) {
        IntNode newNode = new IntNode(x, null);
        newNode.prev = tail;
        if (tail != null) {
            tail.next = newNode;
            tail = newNode;
        } else {
            head = newNode;
            tail = head;
        }
        size++;
    }

    public float peek() {
        if (head != null) {
            return head.item;
        } else {
            return -1;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        DLQueue atm = new DLQueue(15.5F);
        System.out.println("enQueue. Expected 15.5, got " + atm.peek());
        atm.deQueue();
        atm.deQueue();
        System.out.println("enQueue. Expected -1.0, got " + atm.peek());
        atm.enQueue(5.25F);
        System.out.println("enQueue. Expected 5.25, got " + atm.peek());
    }
}
