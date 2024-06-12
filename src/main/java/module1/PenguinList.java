package module1;

public class PenguinList {
    class IntNode {
        public int id;
        public int weight;
        public int height;
        public IntNode next;

        private IntNode(int i, int w, int h, IntNode n)
        {
            id = i;
            weight = w;
            height = h;
            next = n;
        }

    }

    private IntNode first;
    protected int listSize;

    public PenguinList(int i, int w, int h)
    {
        first = new IntNode(i, w, h, null);
        listSize = 1;
    }

    public PenguinList() {
        first = null;
        listSize = 0;
    }

    public int getListSize() {
        return listSize;
    }
    public void addFirst(int id, int weight, int height) {
        first = new IntNode(id, weight, height, first);
        listSize++;
    }

    public void addLast(int id, int weight, int height) {
        if (first == null) {
            first = new IntNode(id, weight, height, null);
        } else {
            IntNode p = first;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new IntNode(id, weight, height, null);
        }
        listSize++;
    }

    public int getLast() {
        if (first == null) {
            throw new IllegalStateException("List is empty");
        }
        IntNode p = first;
        while (p.next != null){
            p = p.next;
        }
        return p.id;
    }

    public int getFirst() {
        if (first == null) {
            throw new IllegalStateException("List is empty");
        }
        return first.id;
    }

    public int totalWeight() {
        return first == null ? 0 : RtotalWeight(first);
    }

    public int RtotalWeight(IntNode p) {
        if (p.next == null) {
            return p.weight;
        }
        return p.weight + RtotalWeight(p.next);
    }

    public int recursiveSize() {
        return first == null ? 0 : RrecursiveSize(first);
    }

    public static int RrecursiveSize(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + RrecursiveSize(p.next);
    }

    public static void main(String[] args) {
        PenguinList penguinList = new PenguinList(111, 1, 25);
        penguinList.addFirst(222, 2, 20000);
        penguinList.addFirst(333, 3, 234234);
        System.out.println("Number of penguin. Expected 3, got " + penguinList.recursiveSize());
        System.out.println("First penguin. Expected 333, got " + penguinList.getFirst());
        System.out.println("Total penguin weight. Expected 6, got " + penguinList.totalWeight());
        System.out.println("Last penguin. Expected 111, got " + penguinList.getLast());
        penguinList.addLast(666, 666, 666);
        System.out.println("Last penguin. Expected 666, got " + penguinList.getLast());
        System.out.println("Using listSize var. Expected 4, got " + penguinList.getListSize());

        PenguinList nullList = new PenguinList();
        System.out.println("Using listSize var. Expected 0, got " + nullList.getListSize());
        nullList.addLast(1, 2, 3);
        System.out.println("Using listSize var. Expected 1, got " + nullList.getListSize());
    }
}
