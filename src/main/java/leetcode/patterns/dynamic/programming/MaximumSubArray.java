package leetcode.patterns.dynamic.programming;

//53. Maximum Subarray
//Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
//A circular array means the end of the array connects to the beginning of the array. 
//Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

//A subarray may only include each element of the fixed buffer nums at most once. 
//Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
// Input: nums = [1,-2,3,-2]
//Output: 3
//Explanation: Subarray [3] has maximum sum 3.
public class MaximumSubArray {
    public static int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i< nums.length; i++){
            sum += nums[i];
            max = Math.max(sum,max);

            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,-2,3,-2};
        int result = maxSubarraySumCircular(input);
        System.out.println("Result is : " + result);
    }
}
