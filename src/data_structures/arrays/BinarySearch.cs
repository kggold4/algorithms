using System;

namespace MyApp
{
    public static class Program
    {
        public static int BinarySearch(int[] array, int item)
        {
            return BinarySearchAlgorithm(array, 0, array.Length, item);
        }

        private static int BinarySearchAlgorithm(int[] array, int low, int high, int item)
        {
            if (high < low)
            {
                return -1;
            }
            int middle = (high + low) / 2;
            if (array[middle] < item)
            {
                return BinarySearchAlgorithm(array, middle + 1, high, item);
            } else if (array[middle] > item)
            {
                return BinarySearchAlgorithm(array, low, middle - 1, item);
            } else
            {
                return middle;
            }
        }

        public static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            int[] arr = { 1, 2, 3, 5, 6, 7, 9 };
            Console.WriteLine(BinarySearch(arr, 1)); // 0
            Console.WriteLine(BinarySearch(arr, 2)); // 1
            Console.WriteLine(BinarySearch(arr, 4)); // -1
            Console.WriteLine(BinarySearch(arr, 5)); // 3
            Console.WriteLine(BinarySearch(arr, 8)); // -1
            Console.WriteLine(BinarySearch(arr, 9)); // 6
            Console.WriteLine("done!");
            Console.ReadLine();
        }
    }
}
