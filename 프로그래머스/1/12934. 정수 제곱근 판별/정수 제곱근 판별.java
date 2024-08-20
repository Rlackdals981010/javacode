class Solution {
    public long solution(long n) {
        double answer = 0;
        double use = Math.sqrt(n);
        if(use==(int)use)
            answer=Math.pow(use+1,2);
        else
            answer=-1;        
        return (long)answer;
    }
}