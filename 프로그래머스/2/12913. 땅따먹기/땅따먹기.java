import java.util.*;

class Solution {
    int solution(int[][] land) {        
        
        int n = land.length;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int maxPrev = 0;
                for (int k = 0; k < land[i].length; k++) {
                    if (k != j) {  
                        maxPrev = Math.max(maxPrev, land[i - 1][k]);
                    }
                }
                land[i][j] += maxPrev;
            }
        }
    
    
       return Math.max(Math.max(land[n-1][0], land[n-1][1]), Math.max(land[n-1][2], land[n-1][3]));
        }
    
    
}