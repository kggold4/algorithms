package data_structures.sorting;

public class CountingSort {

    public static void countingSort(int[] A) {

        int max = 0, index = 0;
        for(int i : A) if(max < i) max = i;
        int[] freq = new int[max+1];
        for(int i = 0; i < A.length; i++) freq[A[i]]++;
        for(int i = 0; i <= max; i++) {
            int m = 0;
            while(m < freq[i]) {
                A[index] = i;
                index++;
                m++;
            }
        }
    }
}
