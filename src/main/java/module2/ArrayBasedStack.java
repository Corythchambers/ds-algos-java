package module2;

import java.lang.reflect.Array;
import java.util.Stack;

public class ArrayBasedStack {
    static class StackNode {
        StackNode next;
        int data;

        StackNode(int num) {
            next = null;
            data = num;
        }
    }

    protected StackNode[] stack;
    private int size;

    public ArrayBasedStack() {
        stack = new StackNode[3];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void push(int n) {
        if (size == stack.length) {
            resize(size * 2);
        }
        stack[size] = new StackNode(n);
        size++;
    }

    public void resize(int capacity) {
        StackNode[] newStack = new StackNode[capacity];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        StackNode tempNode = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return tempNode.data;
    }

    public int peek() {
        if (size == 0) {
            return -1;
        }
        return stack[size - 1].data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        System.out.println("isEmpty. Expected true, got " + arrayBasedStack.isEmpty());
        for (int i = 0; i <= 5; i++) {
            arrayBasedStack.push(i);
        }
        System.out.println("isEmpty. Expected false, got " + arrayBasedStack.isEmpty());
        for (int i = 5; i >= 0; i--) {
            System.out.println("Pop. expected " + i + " got " + arrayBasedStack.pop());
        }
        System.out.println("isEmpty. Expected true, got " + arrayBasedStack.isEmpty());
        arrayBasedStack.push(100);
        System.out.println("Peek. expected 100, got " + arrayBasedStack.peek());
        System.out.println("Pop. expected 100, got " + arrayBasedStack.pop());
        System.out.println("isEmpty. Expected true, got " + arrayBasedStack.isEmpty());

    }
}
