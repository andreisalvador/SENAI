package Sorts;

import java.util.ArrayList;

public final class BubbleSort {
    public static void Sort(int[] arrayToSort) {
        int arrayLength = arrayToSort.length;
        int aux = 0;
        for (int mainIndex = 0; mainIndex < arrayLength; mainIndex++) {
            for (int secondaryIndex = 1; secondaryIndex < (arrayLength - mainIndex); secondaryIndex++) {
                if (arrayToSort[secondaryIndex - 1] > arrayToSort[secondaryIndex]) {
                    aux = arrayToSort[secondaryIndex - 1];
                    arrayToSort[secondaryIndex - 1] = arrayToSort[secondaryIndex];
                    arrayToSort[secondaryIndex] = aux;
                }

            }
        }
    }
}
