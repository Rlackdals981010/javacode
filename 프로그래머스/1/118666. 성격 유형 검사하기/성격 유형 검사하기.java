import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> kakao = new HashMap<>();
        kakao.put('R', 0);
        kakao.put('T', 0);
        kakao.put('C', 0);
        kakao.put('F', 0);
        kakao.put('J', 0);
        kakao.put('M', 0);
        kakao.put('A', 0);
        kakao.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            int score = choices[i];
            char type1 = survey[i].charAt(0);
            char type2 = survey[i].charAt(1);
            
            if (score < 4) {
                kakao.put(type1, kakao.getOrDefault(type1, 0) + (4 - score));
            } else if (score > 4) {
                kakao.put(type2, kakao.getOrDefault(type2, 0) + (score - 4));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(kakao.getOrDefault('R', 0) >= kakao.getOrDefault('T', 0) ? 'R' : 'T');
        sb.append(kakao.getOrDefault('C', 0) >= kakao.getOrDefault('F', 0) ? 'C' : 'F');
        sb.append(kakao.getOrDefault('J', 0) >= kakao.getOrDefault('M', 0) ? 'J' : 'M');
        sb.append(kakao.getOrDefault('A', 0) >= kakao.getOrDefault('N', 0) ? 'A' : 'N');
        
        return sb.toString();
    }
}
