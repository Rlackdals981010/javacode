import java.util.*;
class 둘만의암호 {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        Set<Character> hs = new HashSet<>(); // 혹시라도 있을 중복 skip 문자 처리
        for(char ch : skip.toCharArray()){
            hs.add(ch);
        }

        for(char val : s.toCharArray()){
            int cnt=0; //증가 카운터
            char ret = val;
            while(cnt<index){
                ret++;
                if(ret>'z')ret='a';
                if(!hs.contains(ret))cnt++;
            }
            sb.append(ret);
        }
        return sb.toString();
    }
}