import java.util.*;
class Solution {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    
    public long solution(int n, int[] works) {
        
        for(int work : works){
            pq.offer(work);            
        }
        
        while(n>0){
            n--;
            int val = pq.poll();
            if(val==0){return 0;}
            pq.offer(val-1);
        }
        
        long ret = 0;
        while(pq.size()>0){
            int val = pq.poll();
            ret+=Math.pow(val,2);
        }
        return ret;
    }
}