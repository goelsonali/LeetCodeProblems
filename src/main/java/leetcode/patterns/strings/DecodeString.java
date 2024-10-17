package leetcode.patterns.strings;

//394. Decode String
//Given an encoded string, return its decoded string.
//The encoding rule is: k[encoded_string], where
// the encoded_string inside the square brackets is being repeated exactly k times.
// Note that k is guaranteed to be a positive integer.

import java.util.Stack;

//You may assume that the input string is always valid; there are no extra white spaces,
// square brackets are well-formed, etc. Furthermore, you may assume that the original
// data does not contain any digits and that digits are only for those repeat numbers, k.
// For example, there will not be input like 3a or 2[4].
//The test cases are generated so that the length of the output will never exceed 105.
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
public class DecodeString {
    public static String decode(String s) {
        Stack<Integer> is = new Stack<>();
        Stack<StringBuilder> ss = new Stack<>();

        int num = 0;
        StringBuilder str = new StringBuilder();

        for(char ch : s.toCharArray()) {
            // There will be 4 types of characters --> number, [ , ], character

            if(ch >= '0' && ch <= '9') {
                num = (num * 10) + ch - '0';
            } else if(ch == '[') {
                ss.push(str);
                str = new StringBuilder();

                is.push(num);
                num = 0;
            } else if(ch == ']') {
                StringBuilder temp = str;
                str = ss.pop();
                int count = is.pop();
                str.append(temp.toString().repeat(count));

            } else {
                str.append(ch);
            }
        }
        return str.toString();

    }

    public static void main(String[] args) {
        String input = "3[a]2[bc]";
        String result = decode(input);
    }
}
