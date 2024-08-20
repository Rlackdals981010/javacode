import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int c1 =0;
        int c2 =0;
        
        for(int i=0;i<goal.length;i++){
            String use = goal[i];
            if(cards1[c1].equals(use)){
                if(c1<cards1.length-1)c1++;
            }
            else if (cards2[c2].equals(use)){
                if(c2<cards2.length-1)c2++;
            }
            else return "No";
        }
        return "Yes";
    }
}