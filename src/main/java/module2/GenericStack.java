package module2;

public class GenericStack<T> {
    class GNode {
        GNode next;
        T data;

        GNode(T data) {
            next = null;
            this.data = data;
        }
    }

    private GNode top;

    public GenericStack(T data) {
        top = new GNode(data);
    }

    public T pop() {
        if (top != null) {
            T temp = top.data;
            top = top.next;
            return temp;
        }
        return null;
    }

    public void push(T data) {
        GNode newNode = new GNode(data);
        newNode.next = top;
        top = newNode;
    }

    public T peek() {
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }




}
