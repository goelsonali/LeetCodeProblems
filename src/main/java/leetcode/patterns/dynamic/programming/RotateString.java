package leetcode.patterns.dynamic.programming;

//796. Rotate String
//Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

//A shift on s consists of moving the leftmost character of s to the rightmost position.

//For example, if s = "abcde", then it will be "bcdea" after one shift.
//Input: s = "abcde", goal = "cdeab"
//Output: true
//Input: s = "abcde", goal = "abced"
//Output: false
public class RotateString {

    public static boolean isRotationPossible(String s, String goal) {
        int shiftCounter = 0;
        while(shiftCounter !=s.length()) {
            char c = s.charAt(0);
            s = s.substring(1) + c;
            shiftCounter++;
            if(s.equalsIgnoreCase(goal)){
                break;
            }
        }
        return s.equalsIgnoreCase(goal);
    }

    public static void main(String[] args) {
        String input = "abcde";
        String goal = "cdeab";

        boolean result = isRotationPossible(input,goal);
        System.out.println("Rotation for  input - " + input + " matching the goal - " + goal + " is - " + result);
        String input2 = "abcde";
        String goal2 = "abced";
        result = isRotationPossible(input2,goal2);
        System.out.println("Rotation for  input - "+ input2 + " matching the goal - " + goal2 + " is - " + result);
    }
}
