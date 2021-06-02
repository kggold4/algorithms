package data_structures.sorting;

import data_structures.arrays.Shuffle;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) swap(arr, j ,j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = Shuffle.create_array(100);
        System.out.println("array before sort: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("array after sort: " + Arrays.toString(arr));
    }
}
