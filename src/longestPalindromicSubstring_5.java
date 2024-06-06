//Given a string s, return the longest
//palindromic
//
//substring
// in s.
//
//
//
//Example 1:
//
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
//Example 2:
//
//Input: s = "cbbd"
//Output: "bb"
//
//
//Constraints:
//
//1 <= s.length <= 1000
//s consist of only digits and English letters.

public class longestPalindromicSubstring_5 {
    public static String longestPalindrome(String s) {
        //// create a decreasing size substring window on the string and return the first palindrome match
        // for loop w/ i equalling length of string minus one and decreasing until 0. this will determine window size
        for (int i = s.length()-1; i>=0; i--){
            //// check all possible substrings for palidrome with given window size
            // for loop - length minus window size is how often this will loop. i is window size
            for (int j = 0; j+i <= s.length(); j++){
                // window size starts at length and decreases by 1
                // window slides up over time
                // Call to palidrome checker method
                if (j==i){//edge case with one letter
                    if (palindromeChecker(s)){
                        // return palidome if found otherwise continue
                        return s;
                    }
                } else {
                    if (palindromeChecker(s.substring(j, i+j))) {
                        // return palidome if found otherwise continue
                        return s.substring(j, i+j);
                    }
                }
            }
        }
        //if not found, there s no palindrome
        return "";
    }

    // find a way to determine if a string is a palindrome
    private static boolean palindromeChecker(String s) {
        // have two iterators one going forward and one going backwards check if the characters are equal until they hit the midpoint
        int itrFwrd = 0;
        int itrBwrd = ((s.length())-1);
        // for loop until midpoint is reached by itr's
        for (; (itrFwrd < (s.length())/2) || (itrBwrd > (s.length())/2) || itrFwrd==itrBwrd; itrFwrd++, itrBwrd--){
            // check if characters are equal
            if (!(s.charAt(itrFwrd) == s.charAt(itrBwrd))){
                // if not equal then immediately return false
                return false;
            }
        }
        // after loop finishes that means that loop must be a palindrome
        return true;
    }
    public static void main(String[] args) {
        //Test Data
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
