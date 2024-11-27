class Solution {
    public int[] solution(int[] num_list) {
        int[] ret = {0,0};
        for(int val : num_list){
            if(val%2==0){
                ret[0]++;
            }
            else{
                ret[1]++;
            }        
        }
        return ret;
    }
}