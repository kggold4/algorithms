package data_structures.sorting;

import data_structures.arrays.Lib;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmsTest {

    private static final int n = 100000;
    private static final int max = 100000;
    private static final int[] Original = Lib.create_random_array(n, max);
    private static int[] sortedOriginal = Arrays.copyOf(Original, n);
    private static long getTime() { return System.currentTimeMillis(); }
    private static void printTime(String sort, long time) { System.out.println(sort + " time: " + time + " ms"); }
    private static boolean equalsArrays(int[] A, int[] B) {
        if(A.length != B.length) return false;
        for(int i = 0; i < A.length; i++) if(A[i] != B[i]) return false;
        return true;
    }

    @Test
    void maxSort() {
        int[] A = Arrays.copyOf(Original, n);
        long start = getTime();
        CountingSort.countingSort(A);
        long end = getTime();
        printTime("maxSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(A, sortedOriginal));
    }
    @Test
    void javaSort() {
        int[] B = Arrays.copyOf(Original, n);
        long start = getTime();
        Arrays.sort(B);
        long end = getTime();
        printTime("javaSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(B, sortedOriginal));
    }
    @Test
    void bubbleSort() {
        int[] C = Arrays.copyOf(Original, n);
        long start = getTime();
        BubbleSort.bubbleSort(C);
        long end = getTime();
        printTime("bubbleSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(C, sortedOriginal));
    }
    @Test
    void selectionSort() {
        int[] D = Arrays.copyOf(Original, n);
        long start = getTime();
        SelectionSort.selectionSort(D);
        long end = getTime();
        printTime("selectionSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(D, sortedOriginal));
    }
    @Test
    void insertionSort() {
        int[] E = Arrays.copyOf(Original, n);
        long start = getTime();
        InsertionSort.insertionSort(E);
        long end = getTime();
        printTime("insertionSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(E, sortedOriginal));
    }
    @Test
    void mergeSort() {
        int[] F = Arrays.copyOf(Original, n);
        long start = getTime();
        MergeSort.mergeSort(F);
        long end = getTime();
        printTime("mergeSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(F, sortedOriginal));
    }
    @Test
    void quickSort() {
        int[] G = Arrays.copyOf(Original, n);
        long start = getTime();
        QuickSort.quickSort(G);
        long end = getTime();
        printTime("quickSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(G, sortedOriginal));
    }
}
