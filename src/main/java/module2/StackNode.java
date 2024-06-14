package module2;

public class StackNode {
    public StackNode next;
    public int data;

    public StackNode(int num) {
        next = null;
        data = num;
    }

    public static void main (String[] args) {
        StackNode node1 = new StackNode(8);
        node1.next = new StackNode(10);
    }
}