import java.util.*;

class Solution {
    
    public int[] solution(String msg) {
        
        HashMap<String,Integer> map = new HashMap<>();
        int lastIdx = 1;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(String.valueOf(ch), lastIdx++);
        }        

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < msg.length()) {
            String w = String.valueOf(msg.charAt(i));
            int j = i + 1;        
            
            // 사전에 있는 가장 긴 문자열
            while (j <= msg.length() && map.containsKey(w)) {
                if (j < msg.length()) {
                    w += msg.charAt(j);
                }
                j++;
            }
            
            // 사전에 없는 순간
            if (!map.containsKey(w)) {
                map.put(w, lastIdx++); // 추가하고
                w = w.substring(0, w.length() - 1); // 사용할꺼 마지막 문제 제거
            }
         
            result.add(map.get(w)); // 결과에 추가
            i += w.length();
        }

        int[] fin = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            fin[k] = result.get(k);
        }
        return fin;
    }
}