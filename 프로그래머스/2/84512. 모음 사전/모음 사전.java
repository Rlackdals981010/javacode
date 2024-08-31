import java.util.*;

class Solution {
    public int solution(String word) {
        
        //가중치
        int[] w = new int[5];
        w[4]=1;
        for(int i=3;i>=0;i--){
            w[i]=w[i+1]+(int)Math.pow(5,4-i);
        }
        
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('A',0);
        map.put('E',1);
        map.put('I',2);
        map.put('O',3);
        map.put('U',4);
        
        int ret=word.length();        
        for(int i=0;i<word.length();i++){            
            ret+= map.get(word.charAt(i))*w[i];
        }

        return ret;
        
    }
}
