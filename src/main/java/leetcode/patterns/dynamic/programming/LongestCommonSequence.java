package leetcode.patterns.dynamic.programming;

// 1143. Longest Common Subsequence
//Given two strings text1 and text2, return the length of their longest common subsequence.
// If there is no common subsequence, return 0.
//A subsequence of a string is a new string generated from the original string with some characters (can be none)
// deleted without changing the relative order of the remaining characters.

//For example, "ace" is a subsequence of "abcde".
//A common subsequence of two strings is a subsequence that is common to both strings.
//Input: text1 = "abcde", text2 = "ace"
//Output: 3
//Explanation: The longest common subsequence is "ace" and its length is 3.
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
public class LongestCommonSequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] x = text1.toCharArray();
        char[] y = text2.toCharArray();
        int[][] c = new int[x.length+1][y.length+1];


        for(int i = 1; i< x.length; i++) {
            for(int j = 1; j <y.length; j++){
                if(x[i-1] == y[j-1]) {
                    c[i][j] = 1 + c[i-1][j-1];
                }
                else {
                    c[i][j] = Math.max(c[i][j-1],c[i-1][j]);
                }
            }
        }

        return c[x.length][y.length];

    }

    public static void main(String[] args){
        int result = longestCommonSubsequence("abcde","ace");
    }
}
