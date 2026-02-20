import java.util.Random;
import java.util.function.Consumer;

public class TimeMeasurement {

    public static double measureTime(int n, int runs, Consumer<Integer[]> sortMethod) {
        Random random = new Random(1);

        Integer[][] arrays = new Integer[runs][n];

        for (int i = 0; i < runs; i++) {
            for (int j = 0; j < n; j++) {
                arrays[i][j] = random.nextInt();
            }
        }

        long start = System.nanoTime();

        for (int i = 0; i < runs; i++) {
            sortMethod.accept(arrays[i]);
        }

        long end = System.nanoTime();

        double totalMs = (end - start) / 1_000_000.0;
        return totalMs / runs;
    }

    public static double measureQuickSortEqual(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = 5; // alle like
        }

        long start = System.nanoTime();
        SortingAlgorithms.quickSort(array);
        long end = System.nanoTime();

        return (end - start) / 1_000_000.0;
    }
}
