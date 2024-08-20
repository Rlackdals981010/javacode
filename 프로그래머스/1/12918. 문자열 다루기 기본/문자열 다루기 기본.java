class Solution {
    public boolean solution(String s) {
        boolean flag=true;
        int len = s.length();
        if(len==4||len==6){
            for(int i=0;i<len;i++){
                if(s.charAt(i)-'0'>9){
                    flag=false;
                    break;
                }                    
            }            
        }
        else 
            flag=false;
        
        return flag;
    }
}