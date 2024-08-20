class Solution {
    public int solution(int[] nums) {
        int ret=0;
        for(int i=0;i<=nums.length-3;i++){
            for(int j=i+1;j<=nums.length-2;j++){
                for(int k=j+1;k<=nums.length-1;k++){
                    if(check(nums[i]+nums[j]+nums[k]))ret++;
                }
            }
        }
        return ret;
    }
    public boolean check(int what){
        for(int i=2;i<=Math.sqrt(what);i++){
            if(what%i==0)return false;
        }
        return true;
    }
}