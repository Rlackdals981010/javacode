import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int idx =0;
        
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(words));
        LinkedList<String> list = new LinkedList<>();
        
        for (int i = 0; i < words.length; i++) {
            String val = queue.poll();
            
            // 말한거 한번 더 말한 경우
            if (list.contains(val)) {
                int person = (i % n) + 1;    
                int round = (i / n) + 1;     
                return new int[]{person, round};
            }
            
            // 끝말잇기가 삑난 경우
            if(!list.isEmpty() &&list.getLast().charAt(list.getLast().length()-1)!=val.charAt(0)){
                 int person = (i % n) + 1;    
                int round = (i / n) + 1;     
                return new int[]{person, round};
            }
            list.add(val);
        }        
        return new int[]{0,0};
    }
}