package Sorts;

public class MergeSort {
    public static void Sort(int arrayToSort[], int startIndex, int finalIndex) {
        int middleIndex;
        if (startIndex < finalIndex) {
            middleIndex = (startIndex + finalIndex) / 2;
            Sort(arrayToSort, startIndex, middleIndex);
            Sort(arrayToSort, middleIndex + 1, finalIndex);
            Interleave(arrayToSort, startIndex, middleIndex, finalIndex);
        }
    }

    private static void Interleave(int array[], int startIndex, int middleIndex, int finalIndex) {
        int i, j, k;
        int auxArray[] = new int[array.length];
        for (i = startIndex; i < middleIndex; i++) {
            auxArray[i] = array[i];
        }
        for (j = middleIndex + 1; j < finalIndex; j++) {
            auxArray[finalIndex + middleIndex + 1 - j] = array[j];
        }
        i = startIndex;
        j = finalIndex;
        for (k = startIndex; k < finalIndex; k++) {
            if (auxArray[i] <= auxArray[j]) {
                array[k] = auxArray[i];
                i = i + 1;
            } else {
                array[k] = auxArray[j];
                j = j - 1;
            }
        }
    }
}
