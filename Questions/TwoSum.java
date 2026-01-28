package Questions;
//https://leetcode.com/problems/two-sum/description/
import java.util.*;
public class TwoSum {
    public static int[] twoSumBr(int []nums,int target){
        int []ans = new int[]{-1,-1};
        for(int i = 0;i<nums.length-1;i++){
            int check = target-nums[i];
            for(int j = i+1;j<nums.length;j++){
               if(check == nums[j]){
                ans[0] = i;
                ans[1] = j;
               }
            }
        }
        return ans;


    }
    public static int[] twoSumOpt(int []nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int check = target-nums[i];
            if(map.containsKey(check)){
                return new int[]{map.get(check),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0};
    }
    public static void main(String[] args) {
        int []nums = {2,7,11,15};
        int target = 9;
        
        
        //int []ans = twoSumBr(nums,target);
        int []ans = twoSumOpt(nums,target);
        System.out.println(Arrays.toString(ans));

    }
    
}
