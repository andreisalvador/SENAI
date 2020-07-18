package Sorts;

public class QuickSort {
    public static void Sort(int[] arrayToSort, int startIndex, int finalIndex) {
        if (arrayToSort == null || arrayToSort.length == 0)
            return;

        if (startIndex >= finalIndex)
            return;

        int middleIndex = startIndex + (finalIndex - startIndex) / 2;
        int middleElement = arrayToSort[middleIndex];

        int i = startIndex;
        int j = finalIndex;
        while (i <= j) {
            while (arrayToSort[i] < middleElement) i++;

            while (arrayToSort[j] > middleElement) j--;

            if (i <= j) {
                int aux = arrayToSort[i];
                arrayToSort[i] = arrayToSort[j];
                arrayToSort[j] = aux;
                i++;
                j--;
            }
        }

        if (startIndex < j)
            Sort(arrayToSort, startIndex, j);

        if (finalIndex > i)
            Sort(arrayToSort, i, finalIndex);
    }

    public static void Sort(int[] arrayToSort){
        Sort(arrayToSort, 0, arrayToSort.length - 1);
    }
}
