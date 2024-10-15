package leetcode.patterns.strings;
//2947. Count Beautiful Substrings I
//You are given a string s and a positive integer k.
//Let vowels and consonants be the number of vowels and consonants in a string.
//A string is beautiful if:
//
//vowels == consonants.
//(vowels * consonants) % k == 0, in other terms the multiplication of vowels and consonants is divisible by k.
//Return the number of non-empty beautiful substrings in the given string s.
//
//A substring is a contiguous sequence of characters in a string.
//
//Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
//Consonant letters in English are every letter except vowels.
//Input: s = "baeyh", k = 2
//Output: 2
//Explanation: There are 2 beautiful substrings in the given string.
//- Substring "aeyh", vowels = 2 (["a",e"]), consonants = 2 (["y","h"]).
//You can see that string "aeyh" is beautiful as vowels == consonants and vowels * consonants % k == 0.
//- Substring "baey", vowels = 2 (["a",e"]), consonants = 2 (["b","y"]).
//You can see that string "baey" is beautiful as vowels == consonants and vowels * consonants % k == 0.
//It can be shown that there are only 2 beautiful substrings in the given string.

import java.util.HashSet;
import java.util.Set;

public class BeautifulStrings {
    //steps:
    //Try to think of using 2 pointer pattern
    //Create a Set to store the substring that matches the beautiful string  constraints.
    //Move the right pointer on every iteration
    public static int beautifulSubstrings(String s, int k) {
        Set<String> beautifulStrings = new HashSet<>();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int startPointer = 0;
        while (startPointer < s.length()){
            for(int endPointer = startPointer; endPointer<= s.length(); endPointer++){
                String newString = s.substring(startPointer,endPointer);
                long v = newString.chars().mapToObj(item -> (char) item).filter(vowels::contains).count();
                long con = newString.chars().mapToObj(item -> (char) item).filter(c-> !vowels.contains(c)).count();
                if(v == con && (v * con) % k ==0 && !newString.equals("")){
                    beautifulStrings.add(newString);
                }
            }
            startPointer++;
        }
        return beautifulStrings.size();
    }

    public static void main(String[] args){
        int res = beautifulSubstrings("baeyh",2);
        System.out.println("No. of beautiful strings for the input string - "+ "<baeyh>"+  " is - "+ res);
    }

}
