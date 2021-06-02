package data_structures.arrays;

public class BinarySearch {

    public static int binary_search(int[] arr, int item) {
        return binary_search(arr, item, 0, arr.length-1);
    }

    public static int binary_search(int[] arr, int item, int left, int right) {
        if(left <= right) {

            int middle = left + (right - left) / 2;
            if(arr[middle] == item) {
                return middle;
            } else if(arr[middle] < item) {
                return binary_search(arr, item, middle + 1, right);
            } else {
                return binary_search(arr, item, left, middle - 1);
            }

        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,9};
        System.out.println(binary_search(arr, 2)); // 1
        System.out.println(binary_search(arr, 4)); // -1
        System.out.println(binary_search(arr, 5)); // 3
        System.out.println(binary_search(arr, 8)); // -1
        System.out.println(binary_search(arr, 9)); // 6
    }
}
