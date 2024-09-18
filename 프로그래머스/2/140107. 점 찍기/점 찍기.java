class Solution {
    public long solution(int k, int d) {
        long ret=0;
        
        for(int y = 0 ; y <=d; y+=k){
            int x = (int) Math.sqrt(Math.pow(d, 2) - Math.pow(y, 2));
            ret+=(x/k)+1;
            
        }
        
        return ret;

    }
    
}