import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int ret =0;
        
        Queue<String> que = new LinkedList<>();
        Set<String> set =new HashSet<>(Arrays.asList(words));
        
        if(!set.contains(target)){
            return ret;
        }
        
        que.offer(begin);
        set.remove(begin);
        
        while(que.size()!=0){            
            for(int i=0; i<que.size();i++){
                String cur = que.poll();
                if(cur.equals(target)){
                    return ret;
                }
                for(String use : set.toArray(new String[set.size()])){
                    if(canMove(cur,use)){
                        que.offer(use);
                        set.remove(use);
                    }
                }      
            }     
            
            ret++;
        }
        return 0;
    }    
    private boolean canMove(String s1, String s2){
        int diffCnt = 0;
        for (int i = 0; i<s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                diffCnt++;
            }
        }
        return diffCnt ==1;
    }
   
    
}