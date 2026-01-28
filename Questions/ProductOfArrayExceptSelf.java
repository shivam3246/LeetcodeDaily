package Questions;
import java.util.*;
//https://leetcode.com/problems/product-of-array-except-self/description/

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int []ans = new int[n];
        Arrays.fill(ans,1);
        int current = 1;
        for(int i =0;i<n;i++){
            ans[i]*=current;
            current*=nums[i];
        }
        current=1;
        for(int i =n-1;i>=0;i--){
            ans[i]*=current;
            current*=nums[i];
        }
        return ans;

    }
    public static void main(String[] args) {
        int []nums = {1,2,3,4}; //Output: [24,12,8,6]
        ProductOfArrayExceptSelf pd = new ProductOfArrayExceptSelf();
        int []ans=pd.productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));

    }
    
}
