import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int size = (int) (right - left + 1);  
        int[] result = new int[size];  
        
        for (int i = 0; i < size; i++) {
            long index = left + i;  
            int row = (int) (index / n);  
            int col = (int) (index % n);  
            result[i] = Math.max(row, col) + 1;  
        }
        
        return result;  // 결과 배열 반환
    }
}
