import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> nameHash = new HashMap<>();
        HashMap<Integer,String> rankHash = new HashMap<>();
        
        for(int i=0;i<players.length;i++){
            nameHash.put(players[i],i);
            rankHash.put(i,players[i]);
        }
        
        for(String name : callings){
            //불린사람 순위
            int idx = nameHash.get(name);
            //앞사람 이름 
            String front_name = rankHash.get(idx-1);
            
            //swap
            nameHash.put(front_name,idx);
            nameHash.put(name,idx-1);
            rankHash.put(idx,front_name);
            rankHash.put(idx-1,name);                
        }
        
        String[] ret = new String[rankHash.size()];
        for(int i=0;i<rankHash.size();i++){
            ret[i]=rankHash.get(i);
        }
        return ret;
    }
}