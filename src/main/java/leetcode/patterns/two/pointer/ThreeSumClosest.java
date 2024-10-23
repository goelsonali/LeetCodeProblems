package leetcode.patterns.two.pointer;

import java.util.Arrays;

//16. 3Sum Closest
//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//Return the sum of the three integers.
//
//You may assume that each input would have exactly one solution.
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            int left = i+1;
            int right = nums.length-1;
            while(left<right)
            {
                int currentSum = nums[i] + nums[left] + nums[right];

                if(Math.abs(currentSum - target) < Math.abs(closestSum - target))
                {
                    closestSum = currentSum;
                }

                if(currentSum<target)
                {
                    left++;
                }

                else if(currentSum>target){
                    right--;
                }

                else{
                    return currentSum;
                }


            }
        }

        return closestSum;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int result = threeSumClosest(nums, 1);
        System.out.println("Closest sum is: " + result);

    }
}
