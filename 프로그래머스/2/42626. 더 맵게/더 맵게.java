import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int val : scoville){
            queue.add(val);
        }
        
        int ret = 0;
        
        while (queue.size() > 1 && queue.peek() < K) {
            int min = queue.poll();
            int secondMin = queue.poll();
            queue.add(min + secondMin * 2);
            ret++;
        }
        if (queue.peek() < K) {
            return -1; 
        }
        return ret;                
        
    }
}