import java.util.*;
class Solution {
    public int solution(int[] topping) {
        
        int ret=0;
 
        HashMap<Integer,Integer> front = new HashMap<>();
        HashMap<Integer,Integer> back = new HashMap<>();        
        
        for(int i=0;i<topping.length;i++){
            back.put(topping[i],back.getOrDefault(topping[i],0)+1);
        }
        
        for(int i=0;i<topping.length;i++){
            front.put(topping[i],front.getOrDefault(topping[i],0)+1);
            back.put(topping[i],back.getOrDefault(topping[i],0)-1);
            if (back.get(topping[i]) == 0) {
                back.remove(topping[i]);
            }
            if(checkMap(front,back)){
                ret++;
            }
        }
        return ret;
        
    }
    private boolean checkMap(HashMap<Integer,Integer> front,HashMap<Integer,Integer> back ){
        return front.keySet().size()==back.keySet().size();
    }
}