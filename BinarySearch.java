public class BinarySearch {
    public static boolean binarySearch(int [] nums, int low, int high,int target){
        //base condition
        if (low > high) return false;

        int mid = low + (high - low) / 2;

        if (nums[mid]==target){
            return true;
        } else if (target < nums[mid]) {
            return binarySearch(nums,low,mid-1,target);
        } else {
            return binarySearch(nums,mid+1,high,target);
        }

    }
    public static void main(String[] args) {
      int nums[] = {1,2,3,4,11,100,0};

        System.out.println(binarySearch(nums,0,nums.length-1,1000));
    }
}
