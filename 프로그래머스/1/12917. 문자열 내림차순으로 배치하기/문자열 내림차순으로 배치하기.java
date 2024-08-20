import java.util.*;
class Solution {
    public String solution(String s) {
        
        char[] carr = s.toCharArray();
        
        Arrays.sort(carr);
        StringBuilder sb = new StringBuilder( new String(carr));
        sb.reverse();
        
        return sb.toString();
                
    }
}