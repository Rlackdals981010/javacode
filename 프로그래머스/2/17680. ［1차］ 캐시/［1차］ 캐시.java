import java.util.*;

class Solution {

    private static final int CACHE_HIT = 1;

    private static final int CACHE_MISS = 5;
    
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0){
            return CACHE_MISS*cities.length;
        }
        
        int ret =0;
        Deque<String> deque = new LinkedList<>();
        
        for(String city : cities){
            city = city.toLowerCase();
            //포함
            if(deque.contains(city)){
                ret+=CACHE_HIT;
                deque.remove(city);
                deque.offer(city);    
            }
            //미포함
            else{
                ret+=CACHE_MISS;
                if(deque.size()>=cacheSize){
                    deque.poll(); //LRU
                }
                deque.offer(city);                
            }
            
        }
        return ret;
        
        
    }
}