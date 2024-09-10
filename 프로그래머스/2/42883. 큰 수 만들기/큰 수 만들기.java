class Solution {    
    public String solution(String number, int k) {
        StringBuilder ret = new StringBuilder();  
        int idx = 0;   // 지금
        int maxLen = number.length() - k;  
        
        for (int i = 0; i < maxLen; i++) {
            char max = '0';  
            for (int j = idx; j <= k + i; j++) {  // max의 인덱스 다음부터
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    idx = j + 1;  
                }
            }
            ret.append(max); 
        }
        
        return ret.toString(); 
    }
}
