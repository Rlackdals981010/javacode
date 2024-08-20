import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] use = new int[26];
        Arrays.fill(use,-1);
        
        int[] ret = new int[s.length()];
        
        for(int i=0;i<ret.length;i++){
            ret[i]=use[s.charAt(i)-'a']==-1?-1:i-use[s.charAt(i)-'a'];
            use[s.charAt(i)-'a']=i;
        }
        
        return ret;
        
    }
}