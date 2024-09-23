class Solution {
    public long solution(int w, int h) {        
        int gcd = gcd(w, h);        
        long ret = (long) w * h - (w + h - gcd); // 계산 후 결과 반환
        return ret;
    }
    
    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y); // 유클리드 호제법을 사용한 최대공약수 계산
    }
}
