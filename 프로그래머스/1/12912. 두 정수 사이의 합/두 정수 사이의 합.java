class Solution {
    public long solution(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        
        long total =0;
        
        while(min<max){
            total+=min+++max--;
        }
        if(min==max)
            total+=min;
        
        return total;
        
       
        
    }
}