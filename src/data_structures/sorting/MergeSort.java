package data_structures.sorting;

import data_structures.arrays.Shuffle;
import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low < high - 1) {
            int middle = (low + high) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle, high);

            int n = high - low;
            int[] temp = new int[n];
            int i = low, j = middle, k = 0;

            while(i < middle && j < high) {
                if(arr[j] < arr[i]) temp[k++] = arr[j++];
                else temp[k++] = arr[i++];
            }

            while(i < middle) temp[k++] = arr[i++];
            while(j < high) temp[k++] = arr[j++];

            for(int p = 0; p < n; p++) arr[low + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] arr = Shuffle.create_array(100);
        System.out.println("array before sort: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("array after sort: " + Arrays.toString(arr));
    }
}
