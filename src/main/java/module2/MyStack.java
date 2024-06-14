package module2;

public class MyStack {
    static class StackNode {
        StackNode next;
        int data;

        StackNode(int num) {
            next = null;
            data = num;
        }
    }

    private StackNode top;

    public MyStack() {
        top = null;
    }
    public void push(int num) {
        StackNode newNode = new StackNode(num);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        int peekaboo = -1;
        if (top != null) {
            peekaboo = top.data;
            top = top.next;
        }
        return peekaboo;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println("pop. Expected 3 got " + myStack.pop());
        System.out.println("pop. Expected 2 got " + myStack.pop());
    }
}
