import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        int ret = 1;
        for(Integer val : map.values()){
            ret*= val;
        }
        return ret-1;
    }
}