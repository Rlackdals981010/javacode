import java.util.*;

class Solution {
    
    private HashMap<Integer,Deque<Integer>> map = new HashMap<>();
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        int ret =0;
        visited = new boolean[computers.length];
        
        for(int i = 0 ; i< computers.length;i++){
            Deque<Integer> deque = new LinkedList<>();
            for(int ii=0;ii<computers[i].length;ii++){
                if(computers[i][ii]==1&&i!=ii){
                    deque.offer(ii);
                }
            }
            map.put(i,deque);
        }    
        
        for(int i=0;i<computers.length;i++){
            if(visited[i]==false){
                checkMap(computers,i);
                ret++;
            }
        }
        
        return ret;
        
    }
    private void checkMap(int[][] computers,int start){
        visited[start]=true;
        
        Deque<Integer> deque = map.get(start);
        
        for(int val : deque){            
            if(visited[val]==false){
                checkMap(computers,val);
            }
        }
    }
}