package data_structures.sorting;

public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr ,int low, int high) {
        int pivot = low;
        low++;
        while(low <= high) {
            if(arr[low] <= arr[pivot]) low++;
            else if(arr[high] > arr[pivot]) high--;
            else swap(arr, high, low);
        }
        swap(arr, high, pivot);
        return high;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
