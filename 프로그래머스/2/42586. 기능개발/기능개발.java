import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int  max = 100;
        int[] finish = new int[progresses.length];
        
        for(int i=0;i<finish.length;i++){
            int left = max-progresses[i];
            finish[i] = (left + speeds[i] - 1) / speeds[i];
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        int line = finish[0];
        int cnt=1;
        
        for(int i=1;i<finish.length;i++){
            if(line<finish[i]){
                arr.add(cnt);
                cnt=1;
                line = finish[i];
            }
            else{
                cnt++;
            }
        }
        arr.add(cnt);
        
        int[] ret = new int[arr.size()];
        int idx=0;
        for(Integer val : arr){
            ret[idx++]=val;
        }
        return ret;
    }
}