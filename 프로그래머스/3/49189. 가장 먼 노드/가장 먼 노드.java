import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<Integer>());
        }
        
        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];
            graph.get(from).add(to);
            graph.get(to).add(from); 
        }
            
        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[1]= true;
        queue.offer(1);
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int neighbor : graph.get(current)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    distance[neighbor]=distance[current]+1;
                    queue.offer(neighbor);
                }
            }
        }
        
        int max= 0;
        for(int i : distance){
            max = Math.max(max,i);
        }
        
        int ret = 0;
        for(int i : distance){
            if(max==i){
                ret++;
            }
        }
        
        return ret;
        

    }
}