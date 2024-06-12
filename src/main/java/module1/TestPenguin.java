package module1;

public class TestPenguin {
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
    public void penguinList(int i, int w, int h)
    {
        first = new IntNode(i, w, h, null);
    }
    public void addFirst(int i, int w, int h)
    {
        first = new IntNode(i, w, h, first);
    }
    public int getFirstID()
    {
        return first.id;
    }
    public int getFirstHeight()
    {
        return first.height;
    }
    public int getFirstWeight()
    {
        return first.weight;
    }
    public int iterativeSize()
    {
        IntNode p = first;
        int totalSize = 0;
        while(p != null)
        {
            totalSize++;
            p = p.next;
        }
        return totalSize;
    }
}