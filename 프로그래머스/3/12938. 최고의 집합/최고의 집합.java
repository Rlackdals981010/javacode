import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(n>s){
            return new int[]{-1};
        }
        
        int[] ret = new int[n];        
        int start = s/n;
        int left = s%n;
        Arrays.fill(ret,start);
        
        for(int i=0;i<left;i++){
            ret[n-1-i]+=1;
        }
        return ret;        
    }
}