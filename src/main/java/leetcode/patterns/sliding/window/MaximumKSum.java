package leetcode.patterns.sliding.window;

//You are given an integer array nums consisting of n elements, and an integer k.
//Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
// Any answer with a calculation error less than 10-5 will be accepted.
//
//Example 1:
//
//Input: nums = [1,12,-5,-6,50,3], k = 4 [1,2,3,4,5] , k = 3
//it1 - 6/3 = 2
//it2 - 9/3 = 3
//it3 - 12/3 = 4
//Output: 12.75000
//Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
//Example 2:
//
//Input: nums = [5], k = 1
//Output: 5.00000
public class MaximumKSum {

    //a. Find the sum of the first k elements
    //b. Mark the start pointer=0 and end pointer=k
    //c. while(end<inputlength) -> sum - start + end
    //d. start++ and end ++
    public static double maxSum(int[] input, int k) {
        double ans;
        double sum = 0;
        for (int i = 0; i<k; i++) {
            sum+=input[i];
        }
        ans = sum/k;
        int start = 0;
        int end=k;
        while (end<input.length){
            sum-=input[start];
            sum+=input[end];
            ans = Math.max(ans, sum/k);
            start++;
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,3,4,5};
        double result = maxSum(input,3);
        System.out.println("The result is - " + result);
    }

}
