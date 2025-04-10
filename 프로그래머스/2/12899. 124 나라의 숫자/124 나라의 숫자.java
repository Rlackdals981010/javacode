class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] num = {"1","2","4"};
        
        while(n>0){
            n--;
            sb.insert(0,num[n%3]);
            n/=3;
        }
        return sb.toString();
    }
}