// Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
//
// Example 1:
//
// Input: c = 5
// Output: true
// Explanation: 1 * 1 + 2 * 2 = 5
// Example 2:
//
// Input: c = 3
// Output: false
//
//
// Constraints:
//
// 0 <= c <= 2^31 - 1

import java.lang.Math;
public class SumOfSquareNumbers_633 {

    //Sqrt Int Check
    public static boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }


    // Smarter Brute Force
    /*
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b =  c - (int)(a * a);
            int i = 1, sum = 0;
            while (sum < b) {
                sum += i;
                i += 2;
            }
            if (sum == b)
                return true;
        }
        return false;
    }
    */

    // Too Slow
    // Precomputed Squares Method
    /*
    public static boolean judgeSquareSum(int c) {
        int sqrtC = (int) Math.sqrt(c);
        int nextA = 1;

        nextA = 1;
        for (int a = 0; a <= c/2; a += nextA, nextA += 2) {
            int nextB = nextA;

            for (int b = a; b <= c; b += nextB, nextB += 2){
                if(( c == a + b )){
                    return true;
                }
            }
        }
        return false;
    }
    */

    // Too Slow
    //Brute Force Method with smart constraints
    /*
    public static boolean judgeSquareSum(int c) {
        final int sqrtC = (int) Math.sqrt(c);

        for (int i = 0; i<=sqrtC; i++){
            final int iSq = i*i;
            for (int j = sqrtC; j>=i; j--){
                if (c == (iSq) + (j*j)) {
                    return true;
                }
            }
        }

        return false;
    }
    */

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2147482647));
    }
}


