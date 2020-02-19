using System;
using Afs.MergeSort;

namespace MergeSort.Application
{
    class Program
    {
        static void Main(string[] args)
        {
            MergeSort<int> merge = new MergeSort<int>();
            //merge.DivideArray(new int[] { 3, 4, 5, 4, 6, 7, 8, 9 });

            Console.WriteLine(string.Join(',', merge.OrderArrayByComparation(new int[] { 3,27,38,43}, new int[] { 9,10,82 })));
        }
    }
}
