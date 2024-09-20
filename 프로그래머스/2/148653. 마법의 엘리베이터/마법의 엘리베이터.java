class Solution {
    public int solution(int storey) {
        int ret = 0;

        while (storey > 0) {
            int lastDigit = storey % 10; 
            if (lastDigit > 5) {
                ret += 10 - lastDigit;   
                storey += 10;            
            } else if (lastDigit == 5 && (storey / 10) % 10 >= 5) { // 1자리도 5이상, 2자리도 5 이상이면
                ret += 10 - lastDigit;   // 올림
                storey += 10;
            } else {
                ret += lastDigit;        
            }
            storey /= 10;                
        }

        return ret;
    }
}

