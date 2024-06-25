package module4;

public class BST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        binTree<Integer> addressBook = new binTree<>();
        addressBook.add("Joe", 5556666);
        addressBook.add("Kim", 7778888);
        addressBook.add("Dan", 9991111);

        try
        {
            System.out.println("Searching for  Dan" + addressBook.getValue("Dan"));
        }
        catch (MyException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}
class binTree<Item>
{

    private class node {
        String key;
        Item val;
        node left, right;
    };
    node root;
    public binTree()
    {
        root = null;
    }

    public Item getValue(String key) throws MyException
    {
        node found = treeSearch(root, key);
        if (found != null)
            return found.val;
        else
            throw new MyException("Key not found");

    }

    public void add(String key, Item value)
    {
        root = treeEnter(root, key, value);
    }


    private node treeSearch(node t, String key)
    {

        if (t==null) return null; //doesn't exist
        if (key.compareTo( t.key) < 0)        //found match
        {
            System.out.println("Searching left");
            return treeSearch(t.left, key); //search left
        }

        else if (key.compareTo( t.key) > 0)
        {

            System.out.println( "Searching right");
            return treeSearch(t.right, key);
        }
        else
        {

            return t;
        }
    }

    public node treeEnter(node t, String key, Item value)
    {

        if (t == null)
        {

            node newOne = new node();
            newOne.key = key;
            newOne.val = value;
            newOne.left = newOne.right = null;
            return newOne;
        }
        else if (key.compareTo( t.key) < 0)
        {

            t.left = treeEnter(t.left, key, value);
        }
        else if (key.compareTo( t.key) > 0)
        {

            t.right = treeEnter(t.right, key, value);
        }
        else
        {
            t.val = value;
        }
        return t;
    }

}