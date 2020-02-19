using System;
using System.Collections.Generic;

namespace Afs.MergeSort
{
    public class MergeSort<T>
    {
        public int[] Sort(int[] records)
        {
            return null;
        }


        public int[] OrderArrayByComparation(int[] arrayOne, int[] arrayTwo)
        {
            int[] arrayResult = new int[arrayOne.Length + arrayTwo.Length];

            int indexArrayOne = 0;
            int indexArrayTwo = 0;

            for (int index = 0; index < arrayResult.Length; index++)
            {   
                bool arrayOneGotMax = indexArrayOne == arrayOne.Length;
                bool arrayTwoGotMax = indexArrayTwo == arrayTwo.Length;

                if (arrayOneGotMax || arrayTwoGotMax)
                {
                    arrayResult[index] = arrayOneGotMax ? arrayTwo[indexArrayTwo] : arrayOne[indexArrayOne];

                    if (arrayOneGotMax) indexArrayTwo++;
                    else indexArrayOne++;

                    continue;
                }

                bool isSmaller = arrayTwo[indexArrayTwo] < arrayOne[indexArrayOne];

                if (isSmaller)
                {
                    arrayResult[index] = arrayTwo[indexArrayTwo];
                    indexArrayTwo++;
                }
                else
                {
                    arrayResult[index] = arrayOne[indexArrayOne];
                    indexArrayOne++;
                }
            }

            return arrayResult;
        }

        public (int[], int[]) DivideArray(int[] recods)
        {
            decimal arraysLength = recods.Length / 2m;

            int arrayOneLength = (int)Math.Round(arraysLength, 0, MidpointRounding.AwayFromZero);
            int arrayOneLastIndex = arrayOneLength - 1;

            int arrayTwoStartIndex = arrayOneLastIndex + 1;
            int arrayTwoLastIndex = recods.Length;
            int arrayTwoLength = (arrayTwoStartIndex - arrayTwoLastIndex) * -1;

            int[] arrayOne = new int[arrayOneLength];
            int[] arrayTwo = new int[arrayTwoLength];

            Array.Copy(recods, 0, arrayOne, 0, arrayOneLength);
            Array.Copy(recods, arrayTwoStartIndex, arrayTwo, 0, arrayTwoLength);

            return (arrayOne, arrayTwo);
        }
    }
}

