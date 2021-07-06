package data_structures.arrays;

import java.util.Arrays;

public class Lib {

    /**
     * generate random array by given length
     * @param len
     * @return
     */
    public static int[] create_array(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i;
        }
        Shuffle.shuffle(arr);
        return arr;
    }

    /**
     * generate random array by given length and max
     * @param len
     * @param max
     * @return
     */
    public static int[] create_random_array(int len, int max) {
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = rand_int(0, max);
        }
        return arr;
    }

    /**
     * generate random array by given length, min and max
     * @param len
     * @param max
     * @return
     */
    public static int[] create_random_array(int len, int min,int max) {
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = rand_int(min, max);
        }
        return arr;
    }

    /**
     * return an random integer between range of min and max
     * @param min
     * @param max
     * @return
     */
    public static int rand_int(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) {
        int n = 100;
        int max = 100000;
        int min = -100000;
        System.out.println(Arrays.toString(create_random_array(n, min, max)));
    }
}
