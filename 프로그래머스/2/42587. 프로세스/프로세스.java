import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer val : priorities){
            q.add(val);
        }
        int cnt=0;
        
        while(!q.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                if(priorities[i]==q.peek()){
                    q.poll();
                    cnt++;
                    if(i==location)
                        return cnt;
                }
            }
        }
        return cnt;
    }
}           
