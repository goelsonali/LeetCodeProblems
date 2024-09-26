package leetcode.patterns.sliding.window;

import java.util.HashSet;
import java.util.Set;

//3. Longest Substring Without Repeating Characters
//Given a string s, find the length of the longest
//substring
// without repeating characters.
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//Constraints:
//
//0 <= s.length <= 5 * 104
//s consists of English letters, digits, symbols and spaces.
public class LongestSubString {
    //1. Loop through the every char of the String
    //2. start from beginning and say length as 1,
    // 3. now add next character if not same as 1st one update length
    //4. now add next character and update length until same character is available
    //5. reset the starting pointer

    //Basic Formula
    // s = array or string, window = s[0]+ s[1].. ( until same)

    public static int lengthOfLongestString(String inputString) {
        char[] characters = inputString.toCharArray();
        int resultLength = 0;
        int startWindow = 0;
        Set<Character> uniqueCharacters = new HashSet<>();
        for(int right = 0; right< inputString.length(); right++) {
            if(uniqueCharacters.contains(characters[right])) {
                uniqueCharacters.remove(characters[right]);
                startWindow = startWindow+1;
            }
            uniqueCharacters.add(characters[right]);
            resultLength = Math.max(resultLength, right-startWindow+1);
        }
        return resultLength;
    }

    public static void main(String[] args) {
        //Test1 :
        //Input: s = "abcabcbb"
        //Output: 3
        int result = lengthOfLongestString("abcabcbb");
        System.out.println("Length of the Longest substring - " + result);
        //Test2 :
        //Input: s = "bbbbb"
        //Output: 1
        int result2 = lengthOfLongestString("bbbbb");
        System.out.println("Length of the Longest substring - " + result2);
    }

}
