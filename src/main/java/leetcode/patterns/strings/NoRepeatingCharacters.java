package leetcode.patterns.strings;


import java.util.HashSet;
import java.util.Set;

//3. Longest Substring Without Repeating Characters
//Given a string s, find the length of the longest substring without repeating characters.
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
public class NoRepeatingCharacters {
    //think of sliding pattern
    // for loop -> to loop the entire string characters
    // Create a Set<Char> to store the unique characters.
    // While loop -> for the breakpoint condition to move the window
    // ( in our case -> when the set will contain the repeating character )
    // Within while loop
    // -> slide the start position to next element
    // -> remove the 1st character from the set. ( sliding algo -> remove the element and add the new element/move)



    public static int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueChar = new HashSet<>();
        int start = 0;
        int result = 0;
        for(int right = 0; right< s.length(); right++) {
            while(uniqueChar.contains(s.charAt(right))) {
                uniqueChar.remove(s.charAt(start));
                start +=1;
            }
            uniqueChar.add(s.charAt(right));
            result = Math.max(result, right-start+1);

        }
        return result;

    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        int result = lengthOfLongestSubstring(input);
        System.out.println("The result is : " + result);
    }
}
