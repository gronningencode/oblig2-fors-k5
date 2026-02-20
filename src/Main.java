public class Main {

    public static void main(String[] args) {

        int[] sizes = {3200, 6400, 12800};
        int runs = 5;

        System.out.println("=== INSERTION SORT (O(n^2)) ===");
        runExperiment(sizes, runs, SortingAlgorithms::insertionSort, true);

        System.out.println("\n=== SELECTION SORT (O(n^2)) ===");
        runExperiment(sizes, runs, SortingAlgorithms::selectionSort, true);

        System.out.println("\n=== QUICK SORT (O(n log n)) ===");
        runExperiment(sizes, runs, SortingAlgorithms::quickSort, false);

        System.out.println("\n=== MERGE SORT (O(n log n)) ===");
        runExperiment(sizes, runs, SortingAlgorithms::mergeSort, false);

        System.out.println("\n=== QUICK SORT (ALLE LIKE) ===");
        for (int n : sizes) {
            double time = TimeMeasurement.measureQuickSortEqual(n);
            System.out.println("n = " + n + " | Tid: " + time + " ms");
        }
    }

    private static void runExperiment(int[] sizes, int runs,
                                      java.util.function.Consumer<Integer[]> sortMethod,
                                      boolean quadratic) {

        double c = 0;

        for (int i = 0; i < sizes.length; i++) {

            int n = sizes[i];
            double measured = TimeMeasurement.measureTime(n, runs, sortMethod);

            double f;
            if (quadratic) {
                f = n * (double)n;
            } else {
                f = n * (Math.log(n) / Math.log(2));
            }

            if (i == 0) {
                c = measured / f;
            }

            double theoretical = c * f;

            System.out.printf("n = %d | Målt: %.2f ms | Teoretisk: %.2f ms%n",
                    n, measured, theoretical);
        }
    }
}