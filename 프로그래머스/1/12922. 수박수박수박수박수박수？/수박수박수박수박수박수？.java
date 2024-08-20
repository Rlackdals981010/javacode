class Solution {
    public String solution(int n) {
        String a="수";
        String b="박";
        StringBuilder sb=new StringBuilder();
        int idx=1;
        while(idx<=n){
            if(idx%2!=0)sb.append(a);
            else sb.append(b);
            idx++;
        }
        return sb.toString();
    }
}