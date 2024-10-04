package leetcode.patterns.modified.binary.search;

//33. Search in Rotated Sorted Array
//There is an integer array nums sorted in ascending order (with distinct values).
//
//Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
// such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
// For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
//Example 3:
//
//Input: nums = [1], target = 0
//Output: -1
public class RotatedSortedArray {

    public static int normalBinarySearch(int[] nums, int target) {
        //algo
        //a. Perform a binary search with additional check which part of the array is sorted ?
        //b. We then check if the target is within the range of the sorted half.
        //c. If it is, we search that half; otherwise, we search the other half.

        int mid = nums.length/2;
        int start = 0;
        int end = nums.length -1;

        while(start < end){
            if(nums[mid] == target) {
                return mid;
            } else if (nums[start] < target && target < nums[mid]) {
                end = mid-1;
                mid = (start+end)/2;
            } else if (nums[mid] < target && target < nums[end]) {
                start = mid;
                mid = (start+end)/2;
            }
        }
        return -1;
    }

    public static int modifiedSearch(int[] nums, int target) {
        int mid = nums.length/2;
        int start = 0;
        int end = nums.length-1;

        while(start<=end) {
            if(nums[mid] == target) {
                return mid;
            } else if (nums[start]< nums[mid] && nums[mid] > nums[end] && target < nums[start] ) {//left side rotated
                start = mid+1;
                mid = (start+end)/2;
            } else {
                end = mid-1;
                mid = (start + end) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,5,6,7,0,1,2};
        int target = 8;
        int result = modifiedSearch(input,target);
        System.out.println("For target : " + target + " in array is at position : " + result);
    }
}
