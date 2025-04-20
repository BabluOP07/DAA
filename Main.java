import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       int [] nums = {3,21,29,55,1,0,5};
       quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static int partition(int [] nums, int start, int end){
        int pivot = nums[end];
        int pIndex = start;

        for (int i = start; i <= end - 1 ; i++) {
          if (nums[i] <= pivot){
              int temp = nums[i];
              nums[i] = nums[pIndex];
              nums[pIndex] = temp;
              pIndex++;
          }
        }
        int temp = nums[pIndex];
        nums[pIndex] = nums[end];
        nums[end] = temp;

        return pIndex;

    }


    public static void quickSort(int[] array, int start, int end){
        if (start < end){
            int middle = partition(array,start,end);
            quickSort(array,start,middle-1);
            quickSort(array,middle+1,end);
        }
    }
}