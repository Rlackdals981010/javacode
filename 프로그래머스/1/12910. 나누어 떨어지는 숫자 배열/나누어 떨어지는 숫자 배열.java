import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> alist = new ArrayList<>();
        
        for(int val : arr){
            if(val%divisor==0)
                alist.add(val);
        }
        if(alist.isEmpty())
            return new int[]{-1};
        
        Collections.sort(alist);
        int[] ret = new int[alist.size()];
        for(int i=0;i<alist.size();i++){
            ret[i]=alist.get(i);
        }
        return ret;
    }
}