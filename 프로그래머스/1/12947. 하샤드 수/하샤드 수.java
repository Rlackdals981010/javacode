class Solution {
    public boolean solution(int x) {
        int use =x;
        int total=0;
        while(use>0){
            total+=use%10;
            use/=10;
        }
        return x%total==0?true:false;
        
        
    }
}