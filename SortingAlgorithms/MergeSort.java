package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {2, 6, 77, 2, 4, 88, 0, 1};
        System.out.println("Original Array:" + Arrays.toString(nums));
        mergeSort(nums, nums.length);
        System.out.println("Sorted Array:" + Arrays.toString(nums));
    }


    public static void mergeSort(int[] array, int n) {
        if (n < 2) {  //Base Case
            return;
        }

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = array[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

       merge(array, l, r);

    }

    public static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0; //left half iterator
        int j = 0; //Right Half Iterator
        int k = 0; //Final Array Iterator

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        //Adding left out element in array
        while (i < leftSize) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }

    }


}
