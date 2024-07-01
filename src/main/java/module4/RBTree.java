package module4;

public class RBTree {

    class Node {
        int data;
        Node left, right, parent;
        boolean color; // true = black false = red

        public Node(int data) {
            this.data = data;
        }
    }
    Node root;

    public RBTree() {

    }
    public Node searchNode(int key) {
        Node node = root;
        while (node != null) {
            if (key == node.data) {
                return node;
            } else if (key < node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public void insertNode(int key) {
        Node node = root;
        Node parent = null;

        while (node != null) {
            parent = node;
            if (key < node.data) {
                node = node.left;
            } else if (key > node.data) {
                node = node.right;
            } else {
                throw new IllegalArgumentException("BST already contains a node with key " + key);
            }
        }
        Node newNode = new Node(key);
        newNode.color = false; // ????
        if (parent == null) {
            root = newNode;
        } else if (key < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.parent = parent;

        fixRedBlackPropertiesAfterInsert(newNode);
    }

    private void fixRedBlackPropertiesAfterInsert(Node node) {
        Node parent = node.parent;

        // Case 1 parent is null
        if (parent == null) {
            node.color = true;
            return;
        }

        // parent is black --> do nothing
        if (parent.color == true) {
            return;
        }

        Node grandparent = parent.parent;

        // Case 2:
        // Not having a grandparent means that parent is the root. if we enforce black roots
        // grandparent will never be null and hte following if then block can be removed
        if (grandparent == null) {
            parent.color = true;
            return;
        }

        // get the uncle
        Node uncle = getUncle(parent);

        // Case 3: Uncle is red -> recolor parent, grandparent and uncle
        if (uncle != null && uncle.color == false) {
            parent.color = true;
            grandparent.color = false;
            uncle.color = true;
            //call recursively for grandparent which is now red
            fixRedBlackPropertiesAfterInsert(grandparent);
        }

        // Parent is left child of grandparent
        else if ( parent == grandparent.left) {
            // Case 4a: Uncle is black and node is left->right "inner child" of its grandparent
            if (node == parent.right) {
//                rotateLeft(parent);

                // Let parent point to the new root node of the rotated sub-tree
                // it will be recolored in the next step which were going to fall through to
                parent = node;
            }

            //Case 5a: Uncle is black and node is left->left "outer child" of its grandparent
//            rotateRight(grandparent);

            // Recolor original parent and grandparent
            parent.color = true; // black
            grandparent.color = false; // red
        }

        else {
            // case 4b: uncle is black and node is right->left "inner child" of its grandparent
            if (node == parent.left) {
//                rotateRight(parent);

                // let parent point to thenew root node of the rotated sub-tree
                // it will be recolored in the next step
                parent = node;
            }

            // case 5b uncle is black and node is right-> outer child of its grandparent
//            rotateLeft(grandparent);

            // Recolor original parent and grandparent
            parent.color = true; // black
            grandparent.color = false; // red
        }
    }

    private Node getUncle(Node parent) {
        Node grandparent = parent.parent;
        if (grandparent.left == parent) {
            return grandparent.right;
        } else if (grandparent.right == parent) {
            return grandparent.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }
}
