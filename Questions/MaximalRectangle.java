package Questions;

import java.util.Arrays;

//https://leetcode.com/problems/maximal-rectangle/?envType=daily-question&envId=2026-01-11
public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int n= matrix.length;
        int m = matrix[0].length;
        int []left = new int[m];
        int []right = new int[m];
        int []height = new int[m];
        int maxArea = 0;
        Arrays.fill(right, m);
        for(int i=0;i<n;i++){
            int currLeft = 0;
            int currRight = m;
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }
                else{
                    height[j] = 0;
                }
            }
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(left[j],currLeft);
                }
                else{
                    left[j] = 0;
                    currLeft = j+1;
                }
            }
            for(int j=m-1;j>=0;j--){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(right[j],currRight);
                }
                else{
                    right[j] = m;
                    currRight = j;
                }
            }
            for(int j=0;j<m;j++){
                maxArea = Math.max(maxArea,(right[j]-left[j])*height[j]);
            }
        }
        return maxArea;
    }

    public static void main(String[] args){
        char [][]matrix;
        matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));

    }
}
