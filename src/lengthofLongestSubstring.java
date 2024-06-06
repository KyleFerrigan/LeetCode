public class lengthofLongestSubstring {
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
