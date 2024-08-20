class Solution {
    public String solution(String s) {
        String ret;
        if(s.length()%2==0){
            ret = s.substring(s.length()/2-1,s.length()/2+1);            
        }
        else{
            ret = s.substring(s.length()/2,s.length()/2+1);            
        }
        return ret;
    }
}