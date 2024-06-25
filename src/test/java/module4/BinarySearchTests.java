package module4;

import org.junit.Test;
import static org.junit.Assert.*;

import static module4.BinarySearch.iterativeSearch;

public class BinarySearchTests {

    @Test
    public void testIterativeSearch() {
        int[] testCase = new int[10];
        for (int i = 0; i < 10; i++) {
            int j = 10;
            testCase[i] = j;
            ++;
        }
        assertEquals(2, iterativeSearch(testCase, 2));

    }
}
