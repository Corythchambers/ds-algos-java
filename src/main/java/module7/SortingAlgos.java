package module7;

import java.util.ArrayList;
import java.util.Collections;

public class SortingAlgos {

    public void selectionSort(ArrayList<Integer> v) {
        System.out.println(v);
        for (int i = 0; i < v.size() - 1; i++) {
            // i is the first element on the unsorted side
            int minIndex = i;
            // find index of min in range i to end
            for (int j = i + 1; j < v.size(); j++) {
                if (v.get(j) < v.get(minIndex)) {
                    minIndex = j;
                }
            }
            Collections.swap(v, i, minIndex); // swap min to front
        }
    }

    // could probably use more explanation of this code
    public void insertionSort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int cur = list.get(i); //slide cur down into position to left
            int j = list.get(i);
            for (j = i - 1; j >= 0 && list.get(j) > cur; j--) {
                list.set(j + 1, list.get(j));
            }
            list.set(j + 1, cur);
        }
    }

    public void mergeSort(Integer[] v) {
        if (v.length > 1) {
            int n1 = v.length / 2;
            int n2 = v.length - n1;
            Integer[] left = new Integer[n1];
            Integer[] right = new Integer[n2];
            System.arraycopy(v, 0, left, 0, n1);
            System.arraycopy(v, n1, right, 0, n2);
            mergeSort(left);
            mergeSort(right);
            merge(v, left, right);
        }
    }

    public void merge(Integer[] arr, Integer[] left, Integer[] right) {
        int p, p1, p2;
        p = p1 = p2 = 0;

        while (p1 < left.length && p2 < right.length) {
            if (left[p1] < right[p2]) {
                arr[p++] = left[p1++];
            } else {
                arr[p++] = right[p2++];
            }
        }

        // Handle remaining elements in left array
        while (p1 < left.length) {
            arr[p++] = left[p1++];
        }

        // Handle remaining elements in right array
        while (p2 < right.length) {
            arr[p++] = right[p2++];
        }
    }


    public void quickSort(ArrayList<Integer> v, int start, int stop) {
        if (stop > start) {
            int pivot = Partition(v, start, stop);
            quickSort(v, start, pivot - 1);
            quickSort(v, pivot + 1, stop);
        }
    }

    public int Partition(ArrayList<Integer> arr, int start, int stop) {
        int lh = start + 1;
        int rh = stop;
        int pivot;

        pivot = arr.get(start);
        while(true) {
            while (lh < rh && arr.get(rh) >= pivot) {
                rh--;
            }
            while (lh < rh && arr.get(lh) <= pivot) {
                lh++;
            }
            return lh;
        }
    }
}
