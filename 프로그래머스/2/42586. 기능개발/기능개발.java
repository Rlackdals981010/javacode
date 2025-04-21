import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
                
        List<Integer> result = new ArrayList<>();
        
        Queue<Integer> days = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            int remain = 100 - progresses[i];
            int day = (int) Math.ceil((double)remain/speeds[i]);
            days.offer(day);
        }
        
        int baseDay = days.poll();
        int count =1;
        
        while(!days.isEmpty()){
            int current = days.poll();
            if(current<=baseDay){
                count++;
            }
            else{
                result.add(count);
                baseDay=current;
                count=1;
            }
        }
        result.add(count);
        
        int[] ret = new int[result.size()];
        for(int i=0;i<ret.length;i++){
            ret[i]=result.get(i);
        }
        return ret;       
        
    }
}
