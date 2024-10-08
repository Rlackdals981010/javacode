import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings,new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.charAt(n)==b.charAt(n)){//a가 뒤
                    return a.compareTo(b);
                }    
                else return Character.compare(a.charAt(n),b.charAt(n));
            }
        });
        return strings;
    }
}