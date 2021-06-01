package data_structures.arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,9};
        System.out.println(BinarySearch.binary_search(arr, 2)); // 1
        System.out.println(BinarySearch.binary_search(arr, 4)); // -1
        System.out.println(BinarySearch.binary_search(arr, 5)); // 3
        System.out.println(BinarySearch.binary_search(arr, 8)); // -1
        System.out.println(BinarySearch.binary_search(arr, 9)); // 6
    }
}
