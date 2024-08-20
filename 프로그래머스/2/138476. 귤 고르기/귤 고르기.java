import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int ret=0;
    
        Map<Integer,Integer> map = new HashMap<>();
        for(int val : tangerine){
            map.put(val,map.getOrDefault(val,0)+1);
        }             
        
        List<Integer> arr = new ArrayList<>(map.values());
        Collections.sort(arr,Collections.reverseOrder());   
    
        for(Integer val : arr){
            if(k<=0){
                break;
            }
            ret++;
            k-=val;            
        }
        return ret;
        
        
    }
    

}