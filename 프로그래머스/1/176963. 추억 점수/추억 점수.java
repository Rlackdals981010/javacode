import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        
        int[] ret = new int[photo.length];
        for(int i=0;i<ret.length;i++){
            ret[i]=0;
            for(String names : photo[i]){
                if(map.containsKey(names)){
                    ret[i]+=map.get(names);
                }
            }
        }
        return ret;
    }
}