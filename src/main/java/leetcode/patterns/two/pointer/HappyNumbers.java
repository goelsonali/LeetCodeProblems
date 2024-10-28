package leetcode.patterns.two.pointer;

//202. Happy Number
//Write an algorithm to determine if a number n is happy.
//A happy number is a number defined by the following process:
//Starting with any positive integer, replace the number by the sum of the squares of its digits.
//Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//Those numbers for which this process ends in 1 are happy.
//Return true if n is a happy number, and false if not.
//Input: n = 19
//Output: true
//Explanation:
//1pow(2)+ 9pow(2) = 82
//8pow(2) + 2pow(2) = 68
//6pow(2) + 8pow(2) = 100
//1pow(2) + 0pow(2) + 0pow(2)= 1

import java.util.HashSet;
import java.util.Set;

//Input: n = 2
//Output: false
public class HappyNumbers {

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
