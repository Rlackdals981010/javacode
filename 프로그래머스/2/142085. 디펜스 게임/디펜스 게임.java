import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(k>= enemy.length){
            return enemy.length;
        }
        // 그냥 진행하면서 멈춘곳 기준으로 가장 큰거에 무적권 사용하고 그걸 0으로 교체 하는식
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);    
        
        int ret =0;
        for(int val : enemy){
            n-=val;
            queue.offer(val);
            ret++;
            if(n<0){
                if(k>0){
                    k--;
                    n+=queue.poll();
                }
                else{
                    return ret-1;
                }
                
            }
        }
        return ret;
    }    
}