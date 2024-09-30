package leetcode.patterns.top.k.elements;

import java.util.Collections;
import java.util.PriorityQueue;

//215. Kth Largest Element in an Array
//Given an integer array nums and an integer k, return the kth largest element in the array.
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
//Can you solve it without sorting?
//Example 1:
//
//Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
//Example 2:
//
//Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
//
public class LargestKElement {

    public static int find(int[] nums, int k) {
        //Initialize a Max Heap: Use a priority queue that maintains the elements in reverse order,
        // allowing us to efficiently access the largest elements.
        //Add Elements: Iterate through the input array and add each element to the heap.
        //Poll from the Heap: Remove the largest elements (k-1 times) from the heap.
        // After k-1 removals, the top of the heap will be the k-th largest element.
        //Return the Result: Peek at the top of the heap to get the k-th largest element.

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int n: nums) {
            heap.add(n);
        }
        for (int i = 0; i< k-1; i++ ){
            heap.poll();
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println("The result is - " + find(input,k));
    }
}
