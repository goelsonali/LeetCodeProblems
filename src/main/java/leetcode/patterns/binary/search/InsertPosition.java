package leetcode.patterns.binary.search;

//35. Search Insert Position
//Given a sorted array of distinct integers and a target value,
// return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//You must write an algorithm with O(log n) runtime complexity.

//Input: nums = [1,3,5,6], target = 5
//Output: 2

//Input: nums = [1,3,5,6], target = 2
//Output: 1

//Input: nums = [1,3,5,6], target = 7
//Output: 4
public class InsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int position = 0;
        while(right >= left ) {
            if(target == nums[left] || target < nums[left] ) {
                position = left;
                break;
            } else if (target == nums[right]) {
                position = right;
                break;
            } else if (target > nums[left] && target < nums[left+1]) {
                position = left+1;
                break;
            } else if (target < nums[right] && target > nums[right-1]) {
                position = right-1;
                break;
            } else if (target > left) {
                left++;
            } else {
                right++;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,3,5,6};
        int target = 5;
        int result = searchInsert(input, target);
        System.out.println("The result for the target : "+ target + " is : " + result);

        int[] input1 = new int[] {1,3,5,6};
        int target1 = 2;
        int result1 = searchInsert(input1, target1);
        System.out.println("The result for the target : "+ target1 + " is : " + result1);

        int[] input2 = new int[] {1,3,5,6};
        int target2 = 7;
        int result2 = searchInsert(input2, target2);
        System.out.println("The result for the target : "+ target2 + " is : " + result2);
    }
}
