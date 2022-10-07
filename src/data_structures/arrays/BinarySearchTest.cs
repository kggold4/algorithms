using Microsoft.VisualStudio.TestTools.UnitTesting;
using MyApp;
using System;

namespace MyApp2
{
    [TestClass()]
    public static class ProgramTests
    {
        [TestMethod()]
        public static void BinarySearchTest()
        {
            int[] arr = { 1, 2, 3, 5, 6, 7, 9 };
            Assert.AreEqual(Program.BinarySearch(arr, 1), 0);
            Assert.AreEqual(Program.BinarySearch(arr, 2), 1);
            Assert.AreEqual(Program.BinarySearch(arr, 4), -1);
            Assert.AreEqual(Program.BinarySearch(arr, 5), 3);
            Assert.AreEqual(Program.BinarySearch(arr, 8), -1);
            Assert.AreEqual(Program.BinarySearch(arr, 9), 6);
        }
    }
}