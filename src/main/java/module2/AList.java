package module2;

public class AList {
    class Node {
        String itemName;
        int id;
        private Node(String name, int id) {
            this.itemName = name;
            this.id = id;
        }
    }

    protected int size;
    protected Node[] items;
    public AList() {
        items = new Node[3];
        size = 0;
    }

    public void addLast(String name, int id) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = new Node(name, id);
        size++;
    }

    public String getLast() {
        return items[size - 1].itemName;
    }

    public String getName(int id) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].id == id) {
                return items[i].itemName;
            }
        }
        return "Item not found";
    }

    public int get(int i) {
        return items[i].id;
    }

    public int size() {
        return size;
    }

    public String removeLast() {
        size--;
        String temp = items[size].itemName;
        items[size] = null;
        return temp;
    }

    private void resize(int capacity) {
        Node[] newAList = new Node[capacity];
        System.arraycopy(items, 0, newAList, 0, size);
        items = newAList;
    }

    public static class TestAList {
        public static void main(String[] args) {
            AList aList = new AList();
            aList.addLast("Hi", 1);
            aList.addLast("Bye", 2);
            aList.addLast("Cry", 3);
            aList.addLast("Nye", 4);
            aList.addLast("Fly", 35);

            System.out.println("getLast. Expected 'Fly', got " + aList.getLast());
            System.out.println("getName. Expected 'Bye', got '" + aList.getName(2) + "'");
            System.out.println("get. Expected '1', got '" + aList.get(0) + "'");
            System.out.println("size. expected 5, got " + aList.size());
            System.out.println("removeLast. expected 'Fly', got " + aList.removeLast() + "'");
        }

    }
}
