import java.util.*;
class 달리기경주 {
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


//    public String[] solution(String[] players, String[] callings) {
//
//        HashMap<String,Integer> map = new HashMap<>();
//        for(int i=1;i<=players.length;i++){
//            map.put(players[i-1],i);
//        }
//
//        for(String name: callings){
//            for(String use_name : players){
//                if(map.get(use_name)==map.get(name)-1){
//                    map.put(use_name, map.get(use_name)+1);
//                }
//            }
//            map.put(name, map.get(name)-1);
//        }
//
//        Set<String> hs = map.keySet();
//        String[] ret = new String[map.size()];
//        for(String key : hs){
//            ret[map.get(key)-1]=key;
//        }
//        return ret;
//    }

//    public String[] solution(String[] players, String[] callings) {
//
//        for(String name : callings){
//            int idx;
//            for(idx=0;idx<players.length;idx++){
//                if(players[idx].equals(name))break;
//            }
//
//            String temp = name;
//            players[idx] = players[idx-1];
//            players[idx-1]=temp;
//        }
//
//        return players;
//    }

}