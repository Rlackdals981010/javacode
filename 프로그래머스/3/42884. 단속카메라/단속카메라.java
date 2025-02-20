import java.util.*;
class Solution {
    public int solution(int[][] routes) {
       
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));
        
        int ret = 0;
        int cameraPosition = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            
            if (cameraPosition < route[0]) {
                ret++;
                cameraPosition = route[1]; 
            }
        }
        
        return ret;
        
        
    }
}