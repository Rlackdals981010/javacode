class Solution {
    public int solution(int n, int k) {
        int ret =0;
        String transNum = Integer.toString(n, k);
        String[] transNumArr = transNum.split("0+"); //1001 -> [1],[1]
        for(String use :transNumArr){
            if(check(Long.parseLong(use))){
                ret++;
            }
        }
        return ret;
    
    }
    private boolean check(Long num){
        if(num<2)return false;
        for(long i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)return false;
        }
        return true;
    }
}