package code202407;

public class q41 {
    class Solution {
        public String solution(String s) {
            String[] str = s.split(" ",-1);
            String ret="";

            for(int i=0;i<str.length;i++){
                StringBuilder sb = new StringBuilder(str[i]);
                for(int idx=0;idx<sb.length();idx++){
                    if(idx%2==0)sb.setCharAt(idx,Character.toUpperCase(sb.charAt(idx)));
                    else sb.setCharAt(idx,Character.toLowerCase(sb.charAt(idx)));
                }
                str[i]=sb.toString();
            }
            return String.join(" ",str);
        }
    }
}
