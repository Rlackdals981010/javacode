import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        
        int ret = 0;
        
        int aIdx = 0;
        int bIdx =  0;
        Arrays.sort(B);
        Arrays.sort(A);
        
        while(aIdx<A.length&&bIdx<B.length){
            if(B[bIdx]>A[aIdx]){
                ret++;
                aIdx++;bIdx++;
            }   
            else{
                bIdx++;
            }
        }
        
        return ret;
        
    }
}