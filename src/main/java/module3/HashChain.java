package module3;

import java.util.Arrays;

public class HashChain {
    static int NumBuckets = 99;

    class cellT {
        public String key;
        public int val;
        public cellT next;
        private cellT() {
            val = 0;
            next = null;
        }
        private cellT(String k, int v, cellT n) {
            key = k;
            val = v;
            next = n;
        }
    }
    cellT[] buckets = new cellT[NumBuckets];
    public HashChain() {
        Arrays.fill(buckets, null);
    }
    public int getValue(String key) {
        int whichBucket = hashFunction3(key, NumBuckets);
        cellT match = findCellForKey(key, buckets[whichBucket]);
        if (match  != null) {
            return match.val;
        }
        return -1;
    }
    public void add(String key, int val) {
        int whichBucket = hashFunction3(key, NumBuckets);
        cellT match = findCellForKey(key, buckets[whichBucket]);
        if (match  != null) {
            match.val = val;
        } else {
            cellT newOne = new cellT();
            newOne.key = key;
            newOne.val = val;
            newOne.next = buckets[whichBucket];
            buckets[whichBucket] = newOne;
        }
    }
    public cellT findCellForKey(String key, cellT head) {
        for (cellT cur = head; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return cur;
            }
        }
        return null;
    }

    public cellT rFindIndexForKey(String key, cellT head) {
        if (head == null) {
            return null;
        } else if (head.key.equals(key)) {
            return head;
        } else {
            rFindIndexForKey(key, head.next);
        }
        return null;
    }
    public int hashFunction3(String s, int nBuckets) {
        long Multiplier = -1664117991L;
        long hashcode = 0;
        for (int i = 0; i < s.length(); i++) {
            hashcode = hashcode * Multiplier + s.charAt(i);
        }
        return (int)(hashcode % nBuckets);
    }

    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            for (cellT cur = buckets[i]; cur != null; cur = cur.next) {
                System.out.print(" " + cur.val);
            }
            System.out.println();
        }
    }

}
