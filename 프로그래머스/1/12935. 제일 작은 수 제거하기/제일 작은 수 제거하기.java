import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int min = arr[0];
        for(int val : arr){
            if(val<=min)min=val;
        }
        
        ArrayList<Integer> alist = new ArrayList<>();
        for(int val : arr){
            if(val==min) continue;
            alist.add(val);
        }
        
        if(alist.size()==0)return new int[]{-1};
        int[] ret = new int[alist.size()];
        for(int i=0;i<alist.size();i++){
            ret[i]=alist.get(i);
        }
        return ret;
        
        
        
    }
}