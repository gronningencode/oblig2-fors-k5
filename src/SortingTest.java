import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SortingTest {

    @Test
    void testInsertionSort() {
        Integer[] a = {5, 3, 8, 1, 2};
        SortingAlgorithms.insertionSort(a);
        assertArrayEquals(new Integer[]{1,2,3,5,8}, a);
    }

    @Test
    void testQuickSort() {
        Integer[] a = {9, 4, 6, 2, 7};
        SortingAlgorithms.quickSort(a);
        assertArrayEquals(new Integer[]{2,4,6,7,9}, a);
    }
}
