import java.util.*;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        int[] city = new int[N];
        Arrays.fill(city, Integer.MAX_VALUE);
        city[0]=0;
        
        for(int i=0;i<N;i++){
            map.put(i,new HashMap<>());
        }        
        
        for (int[] r : road) {
            int a = r[0]-1; // 시작 마을
            int b = r[1]-1; // 도착 마을
            int c = r[2]; // 거리            

            map.get(a).put(b, Math.min(map.get(a).getOrDefault(b, Integer.MAX_VALUE), c));   
            map.get(b).put(a, Math.min(map.get(b).getOrDefault(a, Integer.MAX_VALUE), c));
        }        
              
        Deque<Integer> que = new LinkedList<>();
        que.offer(0);
        
        while (!que.isEmpty()) {
            int val = que.poll(); 


            Set<Integer> keys = map.get(val).keySet();
            for (int key : keys) {

                if (city[key] > city[val] + map.get(val).get(key)) {
                    city[key] = city[val] + map.get(val).get(key);
                    que.add(key); 
                }
            }
        }
        
        int ret =0;
        for(int val : city){
            if(val<=K){
                ret++;
            }
        }
        
        return ret;
        
    }
            
    
}