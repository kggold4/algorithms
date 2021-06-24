package data_structures.arrays;

public class FindBestMaxSum {

    // start - the start index of the max sum subarray
    // end - the end index of the max sum subarray
    // max_sum - the best max sum
    int start, end, max_sum;

    public void findBestMaxSum(int[] arr) {
        int temp_sum = start = end = 0, s = 0;
        max_sum = arr[0];

        for(int i = 0; i < arr.length; i++) {

            temp_sum += arr[i];

            if(max_sum < temp_sum) {
                max_sum = temp_sum;
                start = s;
                end = i;
            }

            if(temp_sum < 0) {
                temp_sum = 0;
                s = i + 1;
            }
        }
    }
}
