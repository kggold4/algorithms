package data_structures.sorting;

public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        // O(n^2)
        for(int i = 0; i < arr.length; i++) {
            int j = i;
            int a = arr[j];
            while(j > 0 && arr[j-1] > a) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = a;
        }
        return arr;
    }
}
