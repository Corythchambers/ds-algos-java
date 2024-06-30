package module4;

public class WheresWaldo {
    public static void main(String[] args) {
        WheresWaldo tourists = new WheresWaldo();
        node[] touristList = new node[] {
                new node("Aldo", "Austin"),
                new node("Baldo", "BAustin"),
                new node("CAldo", "CAustin"),
                new node("DAldo", "DAustin"),
                new node("EAldo", "EAustin"),
                new node("FAldo", "FAustin"),
                new node("GAldo", "GAustin"),
                new node("HAldo", "HAustin"),
                new node("IAldo", "IAustin"),
                new node("JAldo", "JAustin"),
                new node("KAldo", "kAustin"),
                new node("LAldo", "lAustin"),
                new node("MAldo", "mAustin"),
                new node("Waldo", "In the cupboard"),
                new node("ZAldo", "zAustin"),
        };
        tourists.load(touristList);
        System.out.println("findMin(). Expected 'Austin, got: " + tourists.findMin());
        System.out.println("findMax(). Expected 'zAustin, got: " + tourists.findMax());
        System.out.println("getValue(). Expected 'In the cupboard', got: " + tourists.getValue("Waldo"));
    }

    node root = null;

    public void load(node[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return;
        }
        root = loadBST(nodes, 0, nodes.length - 1);
    }

    private node loadBST(node[] nodes, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        node newNode = new node(nodes[mid].key, nodes[mid].val);
        newNode.left = loadBST(nodes, start, mid - 1);
        newNode.right = loadBST(nodes, mid + 1, end);

        return newNode;
    }

    public String findMin() {
        return findMinNode(root);
    }

    public String findMinNode(node n) {
        if (n == null) {
            return null;
        }
        if (n.left == null) {
            return n.val;
        }
        return findMinNode(n.left);
    }

    public String findMax() {
        return findMaxNode(root);
    }

    public String findMaxNode(node n) {
        if (n == null) {
            return null;
        } else if (n.right == null) {
            return n.val;
        }
        return findMaxNode(n.right);
    }

    public String getValue(String key) {
        return getValue(root, key);
    }

    private String getValue(node n, String key) {
        if (n == null) {
            return null;
        }
        if (key.compareTo(n.key) < 0) {
            return getValue(n.left, key);
        } else if (key.compareTo(n.key) > 0) {
            return getValue(n.right, key);
        } else {
            return n.val;
        }
    }

}

class node {
    String key;
    String val;
    node left, right;

    node(String key, String val) {
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

