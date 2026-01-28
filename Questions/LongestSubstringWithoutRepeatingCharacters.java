package Questions;
import java.util.*;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubstringWithoutRepeatingCharacters {
     public int lengthOfLongestSubstring(String s) {
        int longestSub = 0;
        
        int []arr = new int[128];
        for(int l = 0,r=0;r<s.length();r++){
           l = Math.max(arr[s.charAt(r)],l);
           longestSub = Math.max(longestSub,r-l+1);
           arr[s.charAt(r)] = r+1;
        }
        return longestSub;

        
    }
    public int lengthOfLongestSubstringOptim(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right  = 0;
        int max = 0;
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                max=Math.max(max,set.size());
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String  s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters lg = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(lg.lengthOfLongestSubstringOptim(s));


        
    }
    
}
