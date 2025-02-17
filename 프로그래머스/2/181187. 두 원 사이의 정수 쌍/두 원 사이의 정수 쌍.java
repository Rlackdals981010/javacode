class Solution {
    public long solution(int r1, int r2) {
        long ret = 0;
        
        for(int x=1;x<=r2;x++){
            long small = (long)Math.ceil(Math.sqrt(1.0*r1*r1- 1.0*x*x));
            long big = (long)Math.floor(Math.sqrt(1.0*r2*r2- 1.0*x*x));
            
            ret += (big-small+1);
        }
        return ret*4;
        
    }       
    
}