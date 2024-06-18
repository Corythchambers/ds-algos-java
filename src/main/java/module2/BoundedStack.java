package module2;

public class BoundedStack<E> {

    class StackNode {
        StackNode next;
        StackNode prev;
        E data;

        StackNode(E data) {
            next = null;
            this.data = data;
        }
    }

    private StackNode top;
    private StackNode bottom;
    private int size;

    public BoundedStack() {
        top = null;
        bottom = null;
        size = 0;
    }

    public void push(E data) {
        StackNode newNode = new StackNode(data);

        if (size == 0) {
            top = bottom = newNode;
        } else {
            newNode.prev = top;
            top.next = newNode;
            top = newNode;
        }

        int capacity = 50;
        if (size == capacity) {
            overflow();
        } else {
            size++;
        }


    }
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        E data = top.data;
        top = top.prev;
        if (top != null) {
            top.next = null;
        } else {
            bottom = null;
        }
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size < 1;
    }

    public int getSize() {
        return size;
    }

    private void overflow() {
        if (bottom == null) {
            return;
        }

        bottom = bottom.next;

        if (bottom != null) {
            bottom.prev = null;
        } else {
            top = null;
        }
    }

    public static void main(String[] args) {
        BoundedStack<String> browserHistory = new BoundedStack<>();
        for (int i = 0; i <= 51; i++) {
            browserHistory.push("www.noplacespecial.com" + i);
        }
        int j = 1;
        while (!browserHistory.isEmpty()) {
            System.out.println(j + " " + browserHistory.pop() + j);
            j++;
        }

        BoundedStack<Double> majiSpellPotency = new BoundedStack<>();
        for (int i = 0; i <= 51; i++) {
            majiSpellPotency.push(12414.34 + i);
        }
        int k = 1;
        while (!majiSpellPotency.isEmpty()) {
            System.out.println(k + " " + majiSpellPotency.pop());
            k++;
        }



    }
}
