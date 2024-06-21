package module3;

public class DynamicCircularQueue {
    private int front, rear, count;
    private int queueMax = 5;
    private float[] info;
    public DynamicCircularQueue() {
        info = new float[queueMax];
        front = 0;
        rear = queueMax -1;
        count = 0;
    }

    public void enQueue(float item) {
        if (count == queueMax) {
            resize(count * 2);
        } else {
            rear = advance(rear);
            info[rear] = item;
            count++;
        }
    }

    public void deQueue() {
        if (count == 0) {
            System.out.println("ERROR: queue is empty");
        } else {
            front = advance(front);
            count--;
        }
    }

    public float peek() {
        return info[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private int advance(int index) {
        index++;
        if (index == queueMax) {
            index = 0;
        }
        return index;
    }

    public void resize(int capacity) {
        float[] tempArray = new float[capacity];
        if (front < rear) {
            System.arraycopy(info, 0, tempArray, 0, count);
        } else {
            int rhs = count - front;
            int lhs = rear + 1;
            System.arraycopy(info, 0, tempArray, 0, lhs);
            System.arraycopy(info, front, tempArray, capacity - rhs, rhs);
            front = capacity - rhs;
        }
        queueMax = capacity;
        info = tempArray;
    }

    public static void main(String[] args) {
        DynamicCircularQueue atm = new DynamicCircularQueue();
        atm.enQueue(144.44F);
        atm.enQueue(155.55F);
        atm.enQueue(166.66F);
        atm.enQueue(177.77F);
        atm.enQueue(188.88F);
        atm.enQueue(199.99F);
        for(int i = 0; i < 6; i++)
        {
            System.out.println(atm.peek());
            atm.deQueue();
        }
    }

}
