package Sorts;

public class MergeSort {


    private static void merge(int arrayToSort[], int leftIndex, int middleIndex, int rightIndex)
    {
        int leftArrayLength = middleIndex - leftIndex + 1;
        int rightArrayLength = rightIndex - middleIndex;
        int leftArray[] = new int[leftArrayLength];
        int rightArray[] = new int[rightArrayLength];

        for (int i = 0; i < leftArrayLength; ++i)
            leftArray[i] = arrayToSort[leftIndex + i];
        for (int j = 0; j < rightArrayLength; ++j)
            rightArray[j] = arrayToSort[middleIndex + 1 + j];

        int i = 0;
        int j = 0;
        int k = leftIndex;

        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i] <= rightArray[j]) {
                arrayToSort[k] = leftArray[i];
                i++;
            }
            else {
                arrayToSort[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArrayLength) {
            arrayToSort[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArrayLength) {
            arrayToSort[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void Sort(int arrayToSort[], int startIndex, int finalIndex)
    {
        if (startIndex < finalIndex) {
            int middleIndex = (startIndex + finalIndex) / 2;

            Sort(arrayToSort, startIndex, middleIndex);
            Sort(arrayToSort, middleIndex + 1, finalIndex);

            merge(arrayToSort, startIndex, middleIndex, finalIndex);
        }
    }

    public static void Sort(int[] arrayToSort){
        Sort(arrayToSort, 0, arrayToSort.length - 1);
    }
}
