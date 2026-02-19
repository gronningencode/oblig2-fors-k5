/// a) Vi observerer at kjøretiden minker noe, men algoritmens orden er fortsatt O(n²). Forbedringen skyles at vi fjerner grensesjekken i den indre løkken

/// c)
public static void improvedInsertionSort(Integer[] a) {
    int n = a.length;
    if (n < 2) return;

    for (int i = n - 1; i > 0; i--) {
        if (a[i] < a[i - 1]) {
            int temp = a[i];
            a[i] = a[i - 1];
            a[i - 1] = temp;
        }
    }

    int i = 2;

    while (i < n) {

        int x = a[i - 1];
        int y = a[i];

        int min, max;
        if (x <= y) {
            min = x;
            max = y;
        } else {
            min = y;
            max = x;
        }

        int j = i - 2;

        while (max < a[j]) {
            a[j + 2] = a[j];
            j--;
        }
        a[j + 2] = max;

        while (min < a[j]) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = min;

        i += 2;
    }

    if (n % 2 != 0) {
        int temp = a[n - 1];
        int j = n - 2;

        while (temp < a[j]) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = temp;
    }
}

public static void main(String[] args) {

    Integer[] a = {5, 3, 8, 1, 4, 7, 2, 6};

    System.out.println("Før sortering:");
    printArray(a);

    improvedInsertionSort(a);

    System.out.println("Etter sortering:");
    printArray(a);
}

private static void printArray(Integer[] a) {
    for (int x : a) {
        System.out.print(x + " ");
    }
    System.out.println();
}



