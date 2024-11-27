import java.util.*;

class Solution {
    public int[] solution(String[] strlist) {
        int[] ret = new int[strlist.length];
        
        for(int i=0;i<ret.length;i++){
            ret[i]=strlist[i].length();
        }
        return ret;
        
        
    }
}