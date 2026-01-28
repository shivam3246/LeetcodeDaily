package Questions;
//https://leetcode.com/problems/longest-consecutive-sequence/description/
import java.util.*;
public class LongestConsectiveSequence {
    public int longestConsecutiveBr(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==i+1){
                ans++;
            }
        }
        return ans;
        
    }
     public int longestConsecutiveOptim(int[] nums) {
        int max  = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int i = 0;i<nums.length;i++){
            int count = 1;
            int number = nums[i];
            while(set.contains(--number)){
                count++;
                set.remove(number);
            }
            number = nums[i];
            while(set.contains(++number)){
                count++;
                set.remove(number);
            }
            max=Math.max(max,count);
        }
        return max;
     }
    public static void main(String[] args) {
        int []nums = {100,4,200,1,3,2};  //O/P=> 4
        LongestConsectiveSequence lg = new LongestConsectiveSequence();
        System.out.println(lg.longestConsecutiveOptim(nums));

    }
    
}
