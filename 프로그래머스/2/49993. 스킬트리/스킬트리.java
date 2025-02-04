import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {          
        int ret = 0;          
        
        for (String useSkill : skill_trees) {                     
            Queue<Character> use = new LinkedList<>();
            for (char ch : skill.toCharArray()) {
                use.offer(ch); 
            }     
            
            boolean check = true;
            
            for(int j=0;j<useSkill.length();j++){
                if(use.contains(useSkill.charAt(j))){
                    if(use.peek() == useSkill.charAt(j)){
                        use.poll();
                    }    
                    else {
                        check = false;
                        break;
                    }
                }                                
            }
            
            if(check){
                ret++;
            }
        }
        return ret;
    }
}