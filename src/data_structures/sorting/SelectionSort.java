package data_structures.sorting;

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min = findMin(arr, i);
            swap(arr, i, min);
        }
        return arr;
    }

    private static int findMin(int[] arr, int from) {
        int min = getMax(arr);
        int index = from;
        for(int i = from; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static int getMax(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) if (max < arr[i]) max = arr[i];
        return max;
    }

    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
