package leetcode.patterns.two.pointer;
//231. Power of Two

//Given an integer n, return true if it is a power of two. Otherwise, return false.
//
//An integer n is a power of two, if there exists an integer x such that n == 2(power of x).

//Input: n = 1
//Output: true
//Explanation: 2(power of 0) = 1

//Input: n = 16
//Output: true
//Explanation: 2(power of 4) = 16

//Input: n = 3
//Output: false
//Constraints: -2pow(31) <= n <= 2pow(31) - 1
public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            int ans = (int) Math.pow(2, i);
            if (ans == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int input1 = 1;
        boolean result = isPowerOfTwo(input1);
        System.out.println("Result for the input = " + input1 + " is : " + result);
        int input2 = 16;
        result = isPowerOfTwo(input2);

        System.out.println("Result for the input = " + input2 + " is : " + result);
        int input3 = 3;
        result = isPowerOfTwo(input3);

        System.out.println("Result for the input = " + input3 + " is : " + result);
    }
}
