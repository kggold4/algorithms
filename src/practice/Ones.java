package practice;

public class Ones {

    /**
     * return the length of the largest subsequence of ones '1'
     * using dynamic programming
     * @param arr
     * @return
     */
    public static int ones(int[] arr) {
        int n = arr.length;
        int[] help = new int[n];
        if(arr[0] == 1) help[0] = 1;

        for(int i = 1; i < n; i++) {
            if(arr[i] != 0) help[i] = help[i-1] + 1;
        }

        // finding max number in help array
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(max < help[i]) max = help[i];
        }
        return max;
    }

    /**
     * print the start and end indexes ad the length of the longest subsequence of ones
     * complexity = O(n)
     * @param arr
     */
    public static void indexes(int[] arr) {
        int n = arr.length;
        int counter = 0, start = 0, end = 0, longest = 0, len = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                if(counter > longest) {
                    end = i - 1;
                    start = i - counter;
                    longest = counter;
                    len = longest;
                }
                counter = 0;
            } else counter++;
        }
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("length: " + len);
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,0,1,1,1,0,0,1,1,0,0,1,1,1,1,1,0,1,0};
        System.out.println(ones(arr));
        indexes(arr);
    }
}
