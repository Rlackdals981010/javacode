import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        if(x==y){
            return 0;
        }        
        
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        
        queue.add(new int[] {x,0});
        set.add(x);
        
        while(!queue.isEmpty()){
            int[] use = queue.poll();
            int val = use[0];
            int count = use[1];
            
            int[] nextVal ={val+n, val*2, val*3};
            for(int nV : nextVal){
                if(nV==y){
                    return count+1;
                }
                
                if(nV<y && !set.contains(nV)){
                    set.add(nV);
                    queue.add(new int[] {nV,count+1});                        
                }
            }
        }
        return -1;
        
    }    
}
