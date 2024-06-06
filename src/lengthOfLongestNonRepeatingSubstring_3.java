//Given a string s, find the length of the longest
//substring
// without repeating characters.
//
//
//
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

public class lengthOfLongestNonRepeatingSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        for (int i = s.length()-1; i >= 0; i--){
            //Window size start big then get smaller over time, shift window as we go
            for (int j = 0; i+j < s.length(); j++){
                //Shift window around in here by difference of length and window size
                if (isStringNonRepeating(s.substring(j,i+j))){
                    System.out.println(s.substring(j,i+j));
                    return i;
                }
            }
        }
        //Should not reach here unless cant find a match
        return 0;
    }
    private boolean isStringNonRepeating(String s){
        String checkedLetters = "";
        //Check if we haven't checked the letter already
        for (int i = 0; i < s.length(); i++){
            if (checkedLetters.contains(String.valueOf(s.charAt(i)))){ //if we already checked a letter no need to check again
                continue;
            } else {
                if (s.substring(i+1).contains(String.valueOf(s.charAt(i)))) {
                    //fail
                    return false;
                } else{
                    // passed/checked
                    checkedLetters = checkedLetters + (s.charAt(i));
                }
            }
        }
        return true;
    }

}
