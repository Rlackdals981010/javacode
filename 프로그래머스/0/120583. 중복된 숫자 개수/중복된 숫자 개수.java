class Solution {
    public int solution(int[] array, int n) {
        int ret =0;
        for(int val : array){
            if(val==n){
                ret++;
            }            
        }
        return ret;
    }
}