package Questions;
//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/?envType=daily-question&envId=2026-01-10

import java.util.Arrays;

public class MMinimumASCIIDeleteSumForTwoStrings {
    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int  [][]dp = new int[m+1][n+1];
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = s1.charAt(i)+dp[i+1][j+1];
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        int total = 0;
        for(char c:s1.toCharArray()){
            total+=c;
        }
        for(char c:s2.toCharArray()){
            total+=c;
        }
        return total-2*dp[0][0];
    }
    public static int minTopDown(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int [][]dp = new int[m+1][n+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        int keep = helper(0,0,s1,s2,dp);
        int total = 0;
        for(char c:s1.toCharArray()){
            total+=c;
        }
        for(char c:s2.toCharArray()){
            total+=c;
        }
        return total-2*keep;
    }
    static int helper(int i,int j,String s1,String s2,int [][]dp){
        if(i==s1.length()||j==s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j] = s1.charAt(i)+helper(i+1,j+1,s1,s2,dp);
        }
        else{
          dp[i][j] = Math.max(helper(i+1,j,s1,s2,dp),helper(i,j+1,s1,s2,dp));
        }
        return dp[i][j];
    }
    static int spaceOptimal(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int []dp = new int[m+1];
        for(int i =  m-1;i>=0;i--){
            int prevIndex = 0;
            for(int j = n-1;j>=0;j--){
                int temp = dp[j];
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[j] = s1.charAt(i)+prevIndex;
                }
                else{
                    dp[j] = Math.max(dp[j+1],dp[j]);
                }
                prevIndex = temp;
            }
        }
        int total = 0;
        for(char c:s1.toCharArray()){
            total+=c;
        }
        for(char c:s2.toCharArray()){
            total+=c;
        }
        return total-2*dp[0];
    }

   static void main() {
        String s1 ="sea";
        String s2 ="eat"; //Output => 231
       //System.out.println(minimumDeleteSum(s1,s2));
       //System.out.println(minTopDown(s1,s2));
       System.out.println(spaceOptimal(s1,s2));


    }
}
