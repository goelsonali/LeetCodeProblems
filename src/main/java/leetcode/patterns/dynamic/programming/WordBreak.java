package leetcode.patterns.dynamic.programming;
//139. Word Break

import java.util.List;

//Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

//Note that the same word in the dictionary may be reused multiple times in the segmentation.
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".


public class WordBreak {

    public static boolean isWordBreak(String s, List<String> wordDict) {

        char[] stringChars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< s.length(); i++) {
            sb.append(stringChars[i]);
            if(wordDict.contains(sb.toString())){
                sb = new StringBuffer();
                
            }
        }

        return sb.isEmpty();
        
    }


    public static void main(String[] args) {
        String input = "leetcode";
        List<String> wordDic = List.of("leet","code");
        boolean result = isWordBreak(input, wordDic);
        System.err.println("The result for string : " + input + "is "+ result);
    }

}
