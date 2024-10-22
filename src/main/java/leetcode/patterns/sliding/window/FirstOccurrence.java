package leetcode.patterns.sliding.window;

//28. Find the Index of the First Occurrence in a String

//Given two strings needle and haystack,
// return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
public class FirstOccurrence {

    public static int getIndexOfNeedle(String haystack, String needle) {
        int result = -1;
        int pointer = 0;
        int right = needle.length();
        while(right <= haystack.length() ) {
            if(haystack.substring(pointer,right).equals(needle)) {
                result = pointer;
                break;
            } else {
                pointer++;
                right++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int result = getIndexOfNeedle("mississippi", "issi");
        System.out.println("The index is: " + result);
    }
}
