import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 1대가 건너려면 bridge_length+1초가 걸림
        // truck_weights로 순서 고정이므로 진입시 시점을 저장하면 된다.
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> time = new LinkedList<>();

        int now_time=0;
        int now_idx=0;        
        long left_weigth=weight;
        
        while(now_idx < truck_weights.length || !bridge.isEmpty()){
            now_time++; // 시간 흐름
            
            if(!time.isEmpty() &&now_time-time.peek()==bridge_length){// 다 건녔으면
                left_weigth+=bridge.poll(); // 차 빼고 무게 다시 추가해주고
                time.poll(); // 시간 빼고                
            }
            
            if(now_idx < truck_weights.length &&left_weigth>=truck_weights[now_idx]){// 올라올 수 있으면
                bridge.offer(truck_weights[now_idx]);
                time.offer(now_time);
                left_weigth -= truck_weights[now_idx];
                now_idx++;
            }
           
        }
        return now_time;
    
    }
}