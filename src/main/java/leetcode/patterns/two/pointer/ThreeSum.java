package leetcode.patterns.two.pointer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    //2 pointer algo
    // create 3 pointer
    //a. pointer1 = 1st element
    //b. pointer2 = 2nd element
    //c. pointer3 = 3rd element

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i< nums.length; i++){
            int pointer1 = i;
            int pointer2 = i;
            int pointer3 = i;
            while(pointer3 != nums.length -1) {
                pointer2++;
                pointer3 = pointer2+1;
                if(nums[pointer1] + nums[pointer2] + nums[pointer3] == 0){
                    result.add(List.of(Integer.valueOf(nums[pointer1]),Integer.valueOf(nums[pointer2]), Integer.valueOf(nums[pointer3])));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int nums = new int(){-1,0,1,2,-1,-4};

    }
}
