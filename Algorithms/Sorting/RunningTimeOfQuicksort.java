package Sorting;

import java.util.Scanner;

public class RunningTimeOfQuicksort {
	
	static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.close();
        quickSort(a.clone());
        int quickSwaps = count;
        count = 0;
        insertionSort(a.clone());
        int insertionSwaps = count;
        System.out.println(insertionSwaps - quickSwaps);
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    private static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        quickSort(a, lo, p - 1);
        quickSort(a, p + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int v = a[hi];
        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (a[i] < v) {
                swap(a, i, j++);
            }
        }
        swap(a, j, hi);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        count++;
        if (i == j) return;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
	
}
