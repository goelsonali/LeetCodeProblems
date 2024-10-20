package leetcode.patterns.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//15. 3Sum
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
public class ThreeSum {
    //Sort the Array:
    //
    //Sort the input array nums to facilitate the two-pointer technique and simplify duplicate handling.
    //Iterate Through the Array:
    //
    //Use a loop to fix the first element of the triplet, ival. For each ival, set up two pointers, left and right, to find the remaining two elements.
    //Skip duplicate elements to ensure uniqueness of triplets.
    //Two-Pointer Technique:
    //
    //For each ival, initialize left to i + 1 and right to nums.length - 1.
    //Calculate the sum of ival, nums[left], and nums[right].
    //If the sum is zero, add the triplet to the result list.
    //If the sum is less than zero, increment left to increase the sum.
    //If the sum is greater than zero, decrement right to decrease the sum.
    //Skip duplicate elements for left to avoid duplicate triplets.
    //Return Result:
    //
    //Return the list of unique triplets that sum to zero.


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i-1] )
                continue;

            int ival = nums[i];

            if (ival > 0)
                break;

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[left] + nums[right] + ival;

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    sums.add(Arrays.asList(ival, nums[left], nums[right]));

                    left++;

                    while(left < right && nums[left] == nums[left-1])
                        left++;

                }//end if



            }//end while

        }//end for


        return sums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);


    }
}
