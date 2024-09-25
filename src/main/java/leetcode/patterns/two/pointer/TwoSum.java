package leetcode.patterns.two.pointer;

// 167. Two Sum II - Input Array Is Sorted
//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number.
// Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//The tests are generated such that there is exactly one solution. You may not use the same element twice.
//Your solution must use only constant extra space.
//Example 1:
//
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
//Example 2:
//
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore, index1 = 1, index2 = 3. We return [1, 3].
//Example 3:
//
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore, index1 = 1, index2 = 2. We return [1, 2].
public class TwoSum {
    // 2 inputs
    // a. An array of integers
    //b. targetSum

    //tests:
    // input: [2,7,11,15] , targ = 9 -> output: [index[2], index[7]]

    //solution
    //a. Need a var start pointer at index[0]
    //b. Need a var end pointer at index[arraylength-1]
    //c. loop through the array and check changing the start and endpointer
    //d. loop breaks when start and endpointer = same index

    public static int[] returnIndexesMatchingTarget(int[] inputOfNumbers, int targetSum) {
        int[] result = new int[2];
        int startPointer;
        int lastPointer;
        boolean success = false;
        for (int i = 0; i< inputOfNumbers.length - 1; i++ ) {
            startPointer = i;
            for(int j = inputOfNumbers.length -1; j >0; j--) {
                lastPointer = j;
                if(inputOfNumbers[startPointer] + inputOfNumbers[lastPointer] == targetSum) {
                    result[0] = startPointer +1;
                    result[1] = lastPointer +1;
                    success = true;
                }
            }
            if (success){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //test1
        // input: [2,7,11,15] , targ = 9 -> output: [1, 2]
        int[] input1 = new int[]{2,7,11,15};
        int target = 9;
        int[] result =  returnIndexesMatchingTarget(input1,target);
        StringBuilder printResult = new StringBuilder();
        printResult.append("[").append(result[0]).append(",").append(result[1]).append("]");
        System.out.println(printResult);
        //test2
        // input: [2,3,4] , targ = 9 -> output: [1, 2]
        int[] input2 = new int[]{2,3,4};
        int target2 = 6;
        int[] result2 =  returnIndexesMatchingTarget(input2,target2);
        StringBuilder printResult2 = new StringBuilder();
        printResult2.append("[").append(result2[0]).append(",").append(result2[1]).append("]");
        System.out.println(printResult2);
    }
}
