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
        addressBook.display();

        try
        {
            System.out.println("Searching for  Dan" + addressBook.getValue("Dan"));
        }
        catch (MyException e)
        {
            System.out.println(e.getMessage());
        }

        addressBook.remove("Dan");
        System.out.println("Tree contains:");
        addressBook.display();
        addressBook.remove("Kim");
        System.out.println("Tree contains:");
        addressBook.display();
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
        else if (key.compareTo(t.key) > 0)
        {

            t.right = treeEnter(t.right, key, value);
        }
        else
        {
            t.val = value;
        }
        return t;
    }

    public void display() {
        inorderPrint(root);
    }

    public void inorderPrint(node n) {
        if (n != null) {
            inorderPrint(n.left);
            System.out.println(n.key + ": " + n.val);
            inorderPrint(n.right);
        }
    }

    public void remove(String k) {
        node gone = deleteNode(root, k);
        System.out.println("Deleted: " + gone.val);
    }

    private node deleteNode(node n, String key) {
        // find the node through in order traversal
        if (n == null) {
            return null;
        } else if (key.compareTo(n.key) < 0) {
            n.left = deleteNode(n.left, key);
        } else if (key.compareTo(n.key) > 0) {
            n.right = deleteNode(n.right, key);
        } else {
            // found it
            // no child
            if (n.left == null) {
                return n.right;
            } else if (key.compareTo(n.key) > 0) {
                return n.left;
            }
            // node with two children: get the inorder successor (smallest in right subtree)
            n.key = minValue(n.right);
            // delete the inorder successor
            n.right = deleteNode(n.right, n.key);
        }
        return n;
    }
    // goes down a tree on the left side looking for the smallest item
    public String minValue(node n) {
        String min = n.key;
        while (n.left != null) {
            min = n.left.key;
            n = n.left;
        }
        return min;
    }

}