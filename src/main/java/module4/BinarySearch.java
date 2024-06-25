package module4;

public class BinarySearch {
    public static int iterativeSearch (int[] a, int searchValue) {
        int left = 0;
        int right = a.length;
        while (left <= right) {
            int midpoint = (left + right) / 2;
            if (a[midpoint] == searchValue) {
                return midpoint;
            } else if (a[midpoint] < searchValue) {
                left = midpoint;
            } else {
                right = midpoint;
            }
        }
        return -1;
    }

    public int recursiveBinarySearch(int[] a, int searchValue, int left, int right) {
        int midpoint = (left + right) / 2;
        if (searchValue == a[midpoint]) {
            return midpoint;
        } else if (a[midpoint] > searchValue) {
            return recursiveBinarySearch(a,searchValue, left, midpoint - 1);
        } else {
            return recursiveBinarySearch(a,searchValue, midpoint + 1, right);
        }
    }

}
