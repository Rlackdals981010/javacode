import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String,Integer> map = new HashMap<>();
        int ret=0;
        
        for(int i =0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
         for (int idx = 0; idx < 10; idx++) {
            map.put(discount[idx], map.getOrDefault(discount[idx], 0) - 1);
        }
        if (check(map)) ret++;

        for (int idx = 10; idx < discount.length; idx++) {
            map.put(discount[idx - 10], map.getOrDefault(discount[idx - 10], 0) + 1);
            map.put(discount[idx], map.getOrDefault(discount[idx], 0) - 1);
            if (check(map)) ret++;
        }
        return ret;
        
        
    }
    boolean check(HashMap<String, Integer> map) {
        for (int value : map.values()) {
            if (value != 0) return false;
        }
        return true;
    }
    
}