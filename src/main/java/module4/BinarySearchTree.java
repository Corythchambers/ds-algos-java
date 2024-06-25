package module4;

public class BinarySearchTree<Item> {
    private class node {
        String key;
        Item val;
        node left, right;

        public node(String key, Item val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    node root;
    public Item getValue(String key) throws Exception {
        node found = treeSearch(root, key);
        if (found != null) {
            return found.val;
        } else {
            throw new Exception("Key not found");
        }
    }

    private node treeSearch(node t, String key) {
        if (t == null) {
            return null;
        }
        if (key.compareTo(t.key) < 0) {
            return treeSearch(t.left, key);
        } else if (key.compareTo(t.key) > 0) {
            return treeSearch(t.right, key);
        } else {
            return t;
        }
    }

    public node treeEnter(node t,  String key, Item value) {
        if (t == null) {
            return new node(key, value);
        } else if (key.compareTo(t.key) < 0) {
            t.left = treeEnter(t.left, key, value);
        } else if (key.compareTo(t.key) > 0 ){
            t.right = treeEnter(t.right, key, value);
        } else {
            t.val = value;
        }
        return t;
    }

    public void add(String key, Item value) {
        root = treeEnter(root, key, value);
    }
}
