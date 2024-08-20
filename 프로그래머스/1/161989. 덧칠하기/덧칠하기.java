import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        Arrays.sort(section);
        int ret =0;
        int now_idx= 0;
        int check_idx=0;
        if(m==1) return section.length;
        while(check_idx<section.length){
            if(section[now_idx]+m-1>=section[check_idx])check_idx++;
            else {
                ret++;
                now_idx=check_idx;
            }
        }
        ret++;
        return ret;
        
    }
}