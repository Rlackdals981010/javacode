class Solution {
    public int solution(int num) {
        long use = num;
        int count=0;
        while(use!=1){
            if(count==500)return -1;
            if(use%2==0)
                use=use/2;
            else{
                use=(use*3)+1;
            }
                
            count++;
        }                              
        
        return count;
    }
}