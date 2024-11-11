import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
            
        int ret = 0;
        double lastShot = -1;
        
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];
            
            if (lastShot < start) {
                ret++;
                lastShot = end - 0.5;
            }
        }

        return ret;
       
    }
    
}