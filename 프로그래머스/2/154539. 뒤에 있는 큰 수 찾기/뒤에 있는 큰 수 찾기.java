import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] ret = new int[numbers.length];
        Arrays.fill(ret,-1);
        
        for(int i=numbers.length-1;i>=1;i--){
            int use = numbers[i];
            for(int j=i-1;j>=0;j--){                
                if(use<=numbers[j]){
                    break;
                }
                ret[j]=use;
                
            }
        }
        return ret;
    }
}