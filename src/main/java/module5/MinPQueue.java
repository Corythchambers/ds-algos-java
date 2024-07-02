package module5;

public class MinPQueue {
    private int[] collection;
    int currentSize = 0;
    public MinPQueue() {
        collection = new int[100];
    }

    public boolean isEmpty() {
        if (currentSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    private int parent(int k){
        return k / 2;
    }
    private int leftChild(int k) {
        return k * 2;
    }

    private int rightChild(int k){
        return (k * 2) + 1;
    }

    private void swap(int target, int destination) {
        int temp = collection[target];
        collection[target] = collection[destination];
        collection[destination] = temp;
    }

    private void swimUp(int k) {
        if (k > 1 && collection[parent(k)] > collection[k]) {
            swap(k, parent(k));
            swimUp(parent(k));
        }
    }

    private void swimDown(int k) {
        // Step 1 child is the holes left child
        int child = leftChild(k);
        if (child <= currentSize) {
            // step 2 update child to right child if smaller than left
            if (collection[child+1] < collection[child]) {
                child++;
            }
            if (collection[child] < collection[k]) {
                swap(k, child);
            }
            swimDown(child); //repeat for child's subtree
        }
    }

    // Client methods

    public boolean add(int item) {
        if (currentSize == collection.length) {
            System.out.println("Out of space! Add resize method");
        } else {
            collection[++currentSize] = item;

            swimUp(currentSize);
        }
        return true;
    }

    public int remove() {
        swap(collection[1], collection[currentSize--]);
        swimDown(1);

        return collection[1];
    }

}
