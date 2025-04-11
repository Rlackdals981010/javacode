import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        
        int[] ret = new int[2];
        
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();
        
        int start = 0, end = 0 ;
        int minLen = Integer.MAX_VALUE;
        
        while(true){
            if(map.size()<gemTypes.size()){
                if(end == gems.length){
                    break;
                }
                map.put(gems[end],map.getOrDefault(gems[end],0)+1);
                end++;
            }
            else{
                if(end-start<minLen){
                    minLen=end-start;
                    ret[0]=start+1;
                    ret[1]=end;
                }
                map.put(gems[start],map.get(gems[start])-1);
                if(map.get(gems[start])==0){
                    map.remove(gems[start]);
                }
                start++;
            }
                
        }

        return ret;
        
        
    }
}