import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt =0;
        int hit=0;
        Arrays.sort(win_nums);
        for(int val : lottos){
            if(val==0)cnt++;
            else{
               if(binS(val,win_nums))hit++;
            }                
        }
        
        
        int max = (hit+cnt==0)?6:7-hit-cnt;        
        int min = (hit==0)?6:7-hit;        
        
        return new int[]{max,min};
    
    }
    
    static boolean binS(int val, int[] win_nums){
        int min = 0;
        int max = win_nums.length-1;
        
        while(min<=max){
            int mid = (min+max)/2;
            if(win_nums[mid]==val)return true;
            else if(win_nums[mid]<val)min=mid+1;
            else max=mid-1;
        }
        
        return false;
    }
}