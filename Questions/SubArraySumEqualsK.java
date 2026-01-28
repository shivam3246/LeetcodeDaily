package Questions;
import java.util.*;
//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            int sum = nums[i];
            if(sum==k){
                ans++;
            }
            for(int j = i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k){
                    ans++;
                }
            }
        }
        return ans;
        
    }
    public int subarraySumOptim(int[] nums, int k) {
        int ans = 0;
        int cSum  = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0;i<nums.length;i++){
            cSum+=nums[i];
            if(map.containsKey(cSum-k)){
                ans+=map.get(cSum-k);
            }
            map.put(cSum,map.getOrDefault(cSum,0)+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] nums = {1,1,1}; //output =2
        int k = 2;
        SubArraySumEqualsK sb = new SubArraySumEqualsK();
        System.out.println(sb.subarraySumOptim(nums, k));
    }
    
}
