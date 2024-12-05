class Solution {
    public String solution(int n, int t, int m, int p) {
        // n : 진법
        // t : 말해야 하는 숫자 개수
        // m : 플레이어 명수
        // p : 튜브의 순서       
        
        int totalLength = (t-1)*m+p;
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while (sb.length() <= totalLength) {
            sb.append(Integer.toString(i, n).toUpperCase());
            i++;
        }
                       
        StringBuilder ret = new StringBuilder();
        for (int j = p - 1; j < totalLength; j += m) {
            ret.append(sb.charAt(j));
        }
        
        return ret.toString();
            
    }
}