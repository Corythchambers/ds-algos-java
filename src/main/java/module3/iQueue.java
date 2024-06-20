package module3;

public interface iQueue {
    void enQueue(float Item);
    void deQueue();
    float peek();
    boolean isEmpty();
    public void pushFront(float x);
    public float peekFront();
    public void popTail();
}
