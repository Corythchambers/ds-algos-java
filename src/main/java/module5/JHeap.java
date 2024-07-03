package module5;

public class JHeap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        maxPQueue leaderBoard = new maxPQueue();
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
        while(!leaderBoard.isEmpty())
            System.out.println(leaderBoard.remove());

    }

}
class maxPQueue
{

    private double[] collection;
    int currentSize = 0;
    public maxPQueue()
    {
        collection = new double[100];
    }

    public boolean isEmpty()
    {
        if (currentSize == 0)
            return true;
        else
            return false;
    }
    private int parent(int k)
    {
        return k/2;
    }
    private int leftChild(int k)
    {
        return k*2;
    }
    private int rightChild(int k)
    {
        return k*2 + 1;
    }

    private void swap(int target, int destination)
    {
        double temp = collection[target];
        collection[target] = collection[destination];
        collection[destination] = temp;
    }
    public boolean add(double item)
    {

        if(currentSize == collection.length)
        {
            System.out.println("Out of space!  Add resize method.");
            return false;
        }
        else
        {

            collection[++currentSize] = item;
            swimUp(currentSize);
        }

        return true;
    }
    private void swimUp(int k)
    {

        if( k > 1 && collection[parent(k)] < collection[k])
        {
            swap(k, parent(k));
            swimUp(parent(k));
        }
    }
    private void swimDown(int hole)
    {
        //Step 1: child is the hole's left child
        int child = leftChild(hole);
        if(child <= currentSize)
        {
            //Step 2: update child to right child if larger than left
            if(collection[child+1] > collection[child])
            {
                child++;
            }
            //swap contents of child and hole if child is larger
            if(collection[child] > collection[hole])
            {
                swap(hole, child);
            }
            swimDown(child);           //repeat for child's subtree
        }

    }
    public double remove()
    {
        double maxItem = collection[1];
        collection[1] = collection[currentSize--];
        swimDown(1);

        return maxItem;
    }
}
