package module4;

public class BTree {
    private int T;

    // Node creation
    public class Node {
        int n;
        int key[] = new int[ 2 * T - 1];
        Node child[] = new Node[2 * T];
        boolean leaf = true;

        public int find(int k) {
            for (int i = 0; i < this.n; i++) {
                if (this.key[i] == k) {
                    return i;
                }
            }
            return -1;
        }
    }

    private Node root;

    public BTree(int t) {
        this.T = t;
        root = new Node();
        root.n = 0;
        root.leaf = true;
    }

    // Search key
    private Node search(Node x, int key) {
        int i = 0;
        if (x == null) {
            return null;
        }
        for (i = 0; i < x.n; i++) {
            if (key < x.key[i]) {
                break;
            }
            if (key == x.key[i]) {
                return x;
            }
        }
        if (x.leaf) {
            return null;
        } else {
            return search(x.child[i], key);
        }
    }

    // Splitting the node
    private void Split(Node x, int pos, Node y) {
        Node z = new Node();
        z.leaf = y.leaf;
        z.n = T - 1;
        for (int j = 0; j < T - 1; j++) {
            z.key[j] = y.key[j + T];
        }
        if (!y.leaf) {
            for (int j = 0; j < T; j++) {
                z.child[j] = y.child[j + T];
            }
        }
        y.n = T - 1;
        for (int j = x.n; j >= pos + 1; j--) {
            x.child[j + 1] = x.child[j];
        }
        x.child[pos + 1] = z;

        for (int j = x.n - 1; j >= pos; j--) {
            x.key[j + 1] = x.key[j];
        }
        x.key[pos] = y.key[T - 1];
        x.n = x.n + 1;
    }

    // inserting a value
    public void insert(final int key) {
        Node r = root;
        if (r.n == 2 * T - 1) {
            Node s = new Node();
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            Split(s, 0 , r);
            insertValue(s, key);
        } else {
            insertValue(r, key);
        }
    }

    // insert the node
    final private void insertValue(Node x, int k) {
        if (x.leaf) {
            int i = 0;
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
                x.key[i + 1] = x.key[i];
            }
            x.key[i + 1] = k;
            x.n = x.n + 1;
        } else {
            int i = 0;
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
            }
            i++;
            Node tmp = x.child[i];
            if (tmp.n == 2 * T - 1) {
                Split(x, i, tmp);
                if (k > x.key[i]) {
                    i++;
                }
            }
            insertValue(x.child[i], k);
        }

    }


    public void Show() {
        Show(root);
    }

    // Display
    private void Show(Node x) {
        assert (x == null);
        for (int i = 0; i < x.n; i++) {
            System.out.print(x.key[i] + " ");
        }
        if (!x.leaf) {
            for (int i = 0; i < x.n + 1; i++) {
                Show(x.child[i]);
            }
        }
    }

    // Check if present
    public boolean Contain(int k) {
        if (this.search(root, k) != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        BTree b = new BTree(3);
        b.insert(8);
        b.insert(9);
        b.insert(10);
        b.insert(11);
        b.insert(15);
        b.insert(20);
        b.insert(17);

        b.Show();

        if (b.Contain(12)) {
            System.out.println("\nfound");
        } else {
            System.out.println("\nnot found");
        }

    }
}
