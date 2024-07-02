package module5;

public class LeaderBoard {

    public static void main(String[] args) {


        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.add(10.0);
        leaderBoard.add(9.0);
        leaderBoard.add(5.0);
        leaderBoard.add(11);
        leaderBoard.add(6.5);
        leaderBoard.add(6.85);
        leaderBoard.add(12);
        leaderBoard.add(1);
        leaderBoard.add(11.5);


        System.out.println("Leader Board Top KD Ratios: ");
        while(!leaderBoard.isEmpty()) {
            System.out.println(leaderBoard.remove());
        }


    }


    private double[] collection;
    int currentSize = 0;
    public LeaderBoard() {
        collection = new double[100];
    }

    private int parent(int k) {
        return k / 2;
    }

    private int leftChild(int k) {
        return k * 2;
    }

    private int rightChild(int k) {
        return (k * 2) + 1;
    }

    public boolean isEmpty()
    {
        if (currentSize == 0)
            return true;
        else
            return false;
    }

    private void swap(int target, int destination) {
        double temp = collection[target];
        collection[target] = collection[destination];
        collection[destination] = temp;
    }

    private void swimUp(int k) {
        if (k > 1 && collection[parent(k)] < collection[k]) {
            swap(k, parent(k));
            swimUp(parent(k));
        }
    }

    private void swimDown(int k) {
        int child = leftChild(k);
        if (child <= currentSize) {
            if (collection[child + 1] > collection[child]) {
                child++;
            }
            if (collection[child] > collection[k]) {
                swap(k, child);
            }
            swimDown(child);
        }
    }

    // Client methods

    public boolean add(double item) {
        // if full return message
        if (currentSize == collection.length) {
            System.out.println("Array is full, resize");
        } else {
            collection[++currentSize] = item;
            swimUp(currentSize);
        }
        return true;
    }

    public double remove() {
        // make sure it's not empty
        if (currentSize < 1) {
            System.out.println("Array is empty");
        } else {
            swap(1, currentSize--);
            swimDown(1);
        }
        return collection[1];
    }
}
