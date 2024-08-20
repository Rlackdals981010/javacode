class Solution {
    public int solution(String t, String p) {
        int len = p.length();
        double b = Double.parseDouble(p);
        int count=0;
        
        for(int i=0;i<=t.length()-len;i++){
            String use = t.substring(i,i+len);
            if(Double.parseDouble(use)<=b)count++;
        }
        return count;
    }
}