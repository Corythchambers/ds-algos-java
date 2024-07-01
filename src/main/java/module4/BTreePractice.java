package module4;

public class BTreePractice {
    private int[] keys;
    private BTreePractice[] subs;
    private int order;
    public BTreePractice(int n) {
        this.keys = new int[n-1];
        this.subs = new BTreePractice[n];
        this.order = n;
    }

    private boolean leaf () {
        for (int i = 0; i < order; i++) {
            if (subs[i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean full() {
        for (int i = 0; i < order; i++) {
            if (subs[i] == null) {
                return false;
            }
        }
        return true;
    }

//    public void traverse() {
//        if (node.leaf()) {
//            for (int i = 0; i < order; i++) {
//                if (keys[i] != -1) {
//                    System.out.println(keys[i] + "\n");
//                }
//            }
//        } else {
//            for (int i = 0; i < node.order; i++) {
//                if (subs[i] != null) {
//                    subs[i].traverse();
//                }
//            }
//        }
//    }
}
