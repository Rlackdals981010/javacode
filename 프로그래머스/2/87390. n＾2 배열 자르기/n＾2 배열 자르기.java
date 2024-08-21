import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int size = (int) (right - left + 1);  
        int[] ret = new int[size];  
        
        for (int i = 0; i < size; i++) {
            long index = left + i;  
            int a = (int) (index / n);  
            int b = (int) (index % n);  
            ret[i] = Math.max(a, b) + 1;  
        }
        
        return ret; 
    }
}
