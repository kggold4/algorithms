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
    void countingSort() {
        int[] A = Arrays.copyOf(Original, n);
        long start = getTime();
        CountingSort.countingSort(A);
        long end = getTime();
        printTime("countingSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(A, sortedOriginal));
    }
    @Test
    void javaSort() {
        int[] A = Arrays.copyOf(Original, n);
        long start = getTime();
        Arrays.sort(A);
        long end = getTime();
        printTime("javaSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(A, sortedOriginal));
    }
    @Test
    void bubbleSort() {
        int[] A = Arrays.copyOf(Original, n);
        long start = getTime();
        BubbleSort.bubbleSort(A);
        long end = getTime();
        printTime("bubbleSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(A, sortedOriginal));
    }
    @Test
    void selectionSort() {
        int[] A = Arrays.copyOf(Original, n);
        long start = getTime();
        SelectionSort.selectionSort(A);
        long end = getTime();
        printTime("selectionSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(A, sortedOriginal));
    }
    @Test
    void insertionSort() {
        int[] A = Arrays.copyOf(Original, n);
        long start = getTime();
        InsertionSort.insertionSort(A);
        long end = getTime();
        printTime("insertionSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(A, sortedOriginal));
    }
    @Test
    void mergeSort() {
        int[] A = Arrays.copyOf(Original, n);
        long start = getTime();
        MergeSort.mergeSort(A);
        long end = getTime();
        printTime("mergeSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(A, sortedOriginal));
    }
    @Test
    void quickSort() {
        int[] A = Arrays.copyOf(Original, n);
        long start = getTime();
        QuickSort.quickSort(A);
        long end = getTime();
        printTime("quickSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(A, sortedOriginal));
    }
    @Test
    void heapSort() {
        int[] A = Arrays.copyOf(Original, n);
        long start = getTime();
        HeapSort.heapSort(A);
        long end = getTime();
        printTime("heapSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(A, sortedOriginal));
    }
    @Test
    void radixSort() {
        int[] A = Arrays.copyOf(Original, n);
        long start = getTime();
        RadixSort.radixSort(A);
        long end = getTime();
        printTime("radixSort", end-start);
        Arrays.sort(sortedOriginal);
        assertEquals(true, equalsArrays(A, sortedOriginal));
    }
}
