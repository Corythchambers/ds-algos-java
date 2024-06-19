package module3;
interface iQueue2 {
    public void enQueue(float Item);
    public void deQueue();
    public float peek();
    public boolean isEmpty();
}
public class Main {

    public static void main(String[] args) {
        DLQueue atm = new DLQueue(15.5F);
        System.out.println(atm.peek());
        atm.deQueue();
        atm.deQueue();
        System.out.println(atm.peek());
        atm.enQueue(100);
    }
}
class DLQueue2 implements iQueue2 {
    class IntNode {
        public float item;
        public IntNode next;
        public IntNode prev;
        private IntNode(float i, IntNode n)
        {
            item = i;
            next = n;
            prev = null;
        }

    }
    private IntNode head;
    private IntNode tail;
    private int size = 1;
    public DLQueue2(float x)
    {
        head = new IntNode(x, null);
        tail = head;

    }
    public void deQueue()
    {

        if (head != null){

            head = head.next;
            size--;
        }
        if (head != null)  {
            head.prev = null;

        }
        if (head == null)
            tail = null;

    }
    public float peek()
    {
        if (head != null)
            return head.item;
        else
            return -1;
    }
    public void enQueue(float x)
    {

        IntNode newOne = new IntNode(x, null);
        newOne.prev = tail;
        if(tail != null) {
            tail.next = newOne;
            tail = newOne;
        }
        else { //empty list adding first node
            head = newOne;
            tail = head;

        }
        size++;
    }

    public int size()
    {
        return size;
    }
    public boolean isEmpty(){
        if(head == null)
            return true;
        else
            return false;
    }
}