package leetcode.patterns.tortoise.hare;

import java.util.HashSet;

//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//There is only one repeated number in nums, return this repeated number.
//You must solve the problem without modifying the array nums and using only constant extra space.
//Example 1:
//
//Input: nums = [1,3,4,2,2]
//Output: 2
//
//Input: nums = [3,1,3,4,2]
//Output: 3
//
//Input: nums = [3,3,3,3,3]
//Output: 3
public class DuplicateNumber {

    //a. create a slow pointer = start at pos = 0
    //b. create a fast pointer = start at pos = 1
    //c. increment the slow pointer + 1
    //d. increment the fast pointer + 1 until fast pointer = length of the array

    public static int getDuplicateUSingPointer(int[] numbers) {
        // Initialize slow and fast pointers
        int slow = numbers[0];
        int fast = numbers[0];

        // Phase 1: Find intersection point inside the cycle
        do {
            slow = numbers[slow];
            fast = numbers[numbers[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle (duplicate number)
        slow = numbers[0];
        while (slow != fast) {
            slow = numbers[slow];
            fast = numbers[fast];
        }

        // Both pointers meet at the duplicate number
        return slow;
    }

    public static int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer i:nums){
            if(!(set.add(i))){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //Input: nums = [1,3,4,2,2]
        //Output: 2
        int[] numbers = new int[] {1,3,4,2,2};
        int result = getDuplicateUSingPointer(numbers);
        System.out.println("Duplicate number is - " + result);
        result = findDuplicate(numbers);
        System.out.println("Duplicate number using hashset is - " + result);
        //Input: nums = [3,1,3,4,2]
        //Output: 3
        int[] numbers2 = new int[] {3,1,3,4,2};
        int result2 = getDuplicateUSingPointer(numbers2);
        System.out.println("Duplicate number is - " + result2);
        result2 = findDuplicate(numbers2);
        System.out.println("Duplicate number using hashset is - " + result2);
    }
}
