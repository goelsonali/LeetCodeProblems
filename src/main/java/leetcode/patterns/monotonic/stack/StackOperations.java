package leetcode.patterns.monotonic.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//1441. Build an Array With Stack Operations
//You are given an integer array target and an integer n.
//You have an empty stack with the two following operations:
//"Push": pushes an integer to the top of the stack.
//"Pop": removes the integer on the top of the stack.
//You also have a stream of the integers in the range [1, n].
//Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target.
// You should follow the following rules:
//If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
//If the stack is not empty, pop the integer at the top of the stack.
//If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.
//Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.
//Input: target = [1,3], n = 3
//Output: ["Push","Push","Pop","Push"]
//Explanation: Initially the stack s is empty. The last element is the top of the stack.
//Read 1 from the stream and push it to the stack. s = [1].
//Read 2 from the stream and push it to the stack. s = [1,2].
//Pop the integer on the top of the stack. s = [1].
//Read 3 from the stream and push it to the stack. s = [1,3].
public class StackOperations {
    public static List<String> buildArray(Integer[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        stack.push(1);
        result.add("Push");
      for(int i = 2; i<=n; i++) {
          if(stack.peek()!=i) {
              stack.push(i);
              result.add("Push");
          } if(Arrays.equals(target,stack.toArray())) {
            break;
          } else if(Arrays.stream(target).noneMatch(num -> num.equals(stack.peek()))){
              stack.pop();
              result.add("Pop");
          }
      }
      return result;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,3};
        int n = 3;
        List<String> result = buildArray(input,n);
        System.out.println("----List 1 result---");
        result.forEach(System.out::println);
        //
        Integer[] input2 = new Integer[]{1,2,3};
        List<String> result2 = buildArray(input2,n);
        System.out.println("----List 2 result---");
        result2.forEach(System.out::println);

        Integer[] input3 = new Integer[]{1,2};
        n=4;
        List<String> result3 = buildArray(input3,n);
        System.out.println("----List 3 result---");
        result3.forEach(System.out::println);
    }
}
