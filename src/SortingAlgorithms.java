import java.util.Arrays;

public class SortingAlgorithms {

    //Insertion Sort
    public static void insertionSort(Integer[] a) {
        for (int i = 1; i < a.length; i++) {
            Integer key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    // Selection Sort
    public static void selectionSort(Integer[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            Integer temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    // Quick Sort
    public static void quickSort(Integer[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(Integer[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    private static int partition(Integer[] a, int low, int high) {
        Integer pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }

        swap(a, i + 1, high);
        return i + 1;
    }

    // Merge Sort
    public static void mergeSort(Integer[] a) {
        if (a.length > 1) {
            int mid = a.length / 2;

            Integer[] left = Arrays.copyOfRange(a, 0, mid);
            Integer[] right = Arrays.copyOfRange(a, mid, a.length);

            mergeSort(left);
            mergeSort(right);

            merge(a, left, right);
        }
    }

    private static void merge(Integer[] a, Integer[] left, Integer[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        while (i < left.length) {
            a[k++] = left[i++];
        }

        while (j < right.length) {
            a[k++] = right[j++];
        }
    }

    private static void swap(Integer[] a, int i, int j) {
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
