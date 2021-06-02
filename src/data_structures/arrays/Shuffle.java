package data_structures.arrays;

import java.util.Arrays;

public class Shuffle {
    public static void shuffle(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * ((i) + 1));
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * generate random array by given length
     * @param len
     * @return
     */
    public static int[] create_array(int len) {
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = i;
        }
        shuffle(arr);
        return arr;
    }
}
