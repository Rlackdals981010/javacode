import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long ret =0;
        
        Arrays.sort(times);
        long left = times[0];
        long right = (long)times[times.length-1]*n;
        
        while(left<=right){
            long mid = (left+right)/2;
            long pivot = findTime(times,mid);
            if(pivot>=n){
                ret = mid;        
                right=mid-1;                                      
            }
            else{
                left=mid+1;
            }
        }
        return ret;
        
    }
    private long findTime(int[] times, long mid){
        long total=0;
        for(int time : times){
            total+=mid/time;
        }
        return total;
    }

}