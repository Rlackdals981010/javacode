import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        
               
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0]=triangle[0][0];
        
        for(int i=0;i<triangle.length-1;i++){
            for(int ii=0;ii<triangle[i].length;ii++){                
                dp[i+1][ii]=Math.max(dp[i+1][ii],dp[i][ii]+triangle[i+1][ii]);                
                if(ii+1<triangle.length){
                    dp[i+1][ii+1]=Math.max(dp[i+1][ii+1],dp[i][ii]+triangle[i+1][ii+1]);
                }                
            }
        }
        return Arrays.stream(dp[triangle.length-1]).max().getAsInt();
        
    }
    
}