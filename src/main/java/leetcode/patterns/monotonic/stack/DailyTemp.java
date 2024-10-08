package leetcode.patterns.monotonic.stack;

//739. Daily Temperatures
//Given an array of integers temperatures represents the daily temperatures,
// return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
// If there is no future day for which this is possible, keep answer[i] == 0 instead.

//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]

//Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]

import java.util.Arrays;
import java.util.Stack;

//Input: temperatures = [30,60,90]
//Output: [1,1,0]
public class DailyTemp {
    //using monotonicstack algo
    //1. Push the 1st element of the array to the stack.
    //2. Iterating the array of the input array.
    //3. Keep adding the element to the stack until the condition is met ( eg - when the next high number is available)
    //4. if the highest number at the nth position then, pop the element from the stack
    // and update the value = 1 on that element's position in the array

    public static int[] dailyTemperatures(int[] temperatures){
        int[] result = new int[temperatures.length];
        Arrays.fill(result,0);
        Stack<Integer> elementStack = new Stack<>();
        for(int i = 0; i< temperatures.length; i++) {
            while(!elementStack.isEmpty() && temperatures[elementStack.peek()] < temperatures[i]) {
                    result[elementStack.peek()] = i-elementStack.pop();
                }
            elementStack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[] {89,62,70,58,47,47,46,76,100,70};
        int[] result = dailyTemperatures(input);
        Arrays.stream(result).forEach(System.out::println);

        //expected - [8,1,5,4,3,2,1,1,0,0]
    }
}
