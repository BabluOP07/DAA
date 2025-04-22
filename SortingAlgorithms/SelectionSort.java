package SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n ; i++) {
            int minIndex = i;
            for (int j = i+1; j < n ; j++) {
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            //Swap
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int nums[] = {22,1,34,2,22,3,0};
        System.out.println(Arrays.toString(nums));
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
