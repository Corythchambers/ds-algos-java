package module2;

public class WalrusList {

    public static class WalrusNode {
        int id;
        int weight;
        int tuskLength;

        private WalrusNode(int id, int weight, int tuskLength) {
            this.id = id;
            this.weight = weight;
            this.tuskLength = tuskLength;
        }
    }
    protected WalrusNode[] walruses;
    protected int size;

    public WalrusList() {
        walruses = new WalrusNode[3];
        size = 0;
    }
    public void addLast(int id, int weight, int tuskLength) {
        if (size == walruses.length) {
            resize(size * 2);
        }
        walruses[size] = new WalrusNode(id, weight, tuskLength);
        size++;
    }

    private void resize(int capacity) {
        WalrusNode[] newList = new WalrusNode[capacity];
        System.arraycopy(walruses, 0, newList, 0, size);
        walruses = newList;
    }

    public int size() {
        return size;
    }

    public int getFirstId() {
        return walruses[0].id;
    }

    public int getFirstWeight() {
        return walruses[0].weight;
    }

    public int getFirstTuskLength() {
        return walruses[0].tuskLength;
    }

    public void addFirst(int id, int weight, int tuskLength) {
        if (size == walruses.length - 1) {
            resize(size * 2);
        }
        shiftNodes();
        walruses[0] = new WalrusNode(id, weight, tuskLength);
        size++;
    }

    private void shiftNodes() {
        for (int i = size; i >= 0; i--) {
            walruses[i + 1] = walruses[i];
        }
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (int i = 0; i < size; i++) {
            totalWeight += walruses[i].weight;
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        WalrusList walrusList = new WalrusList();
        walrusList.addLast(1, 100, 10);
        walrusList.addLast(2, 200, 20);
        walrusList.addLast(3, 300, 30);
        System.out.println("size. Expected 3, got: " + walrusList.size());

        System.out.println("getFirstId. Expected 1, got: " + walrusList.getFirstId());
        System.out.println("getFirstWeight. Expected 100, got: " + walrusList.getFirstWeight());
        System.out.println("getFirstTuskLength. Expected 10, got: " + walrusList.getFirstTuskLength());

        walrusList.addFirst(4, 400, 40);
        System.out.println("size. Expected 4, got: " + walrusList.size());
        System.out.println("getFirstId. Expected 4, got: " + walrusList.getFirstId());
        System.out.println("getFirstWeight. Expected 400, got: " + walrusList.getFirstWeight());
        System.out.println("getFirstTuskLength. Expected 40, got: " + walrusList.getFirstTuskLength());

        System.out.println("getTotalWeight. Expected 1000, got " + walrusList.getTotalWeight());

    }
}
