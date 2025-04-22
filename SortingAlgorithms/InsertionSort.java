package SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j];
                --j;
            }
            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int nums[] = {22, 1, 34, 2, 22, 3, 0};
        System.out.println(Arrays.toString(nums));
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
