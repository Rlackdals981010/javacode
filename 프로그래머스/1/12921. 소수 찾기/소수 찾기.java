class Solution {
    public int solution(int n) {
        int[] nums = new int[n+1];
        
        for(int i=2;i<=n;i++){
            nums[i]=i;
        }
        
        for(int i=2;i<Math.sqrt(n);i++){
            if(nums[i]==0){
                continue;
            }
            for(int j=i*2;j<=n;j=j+i){
                nums[j]=0;
            }
        }
        
        int ret =0;
        for(int num:nums){
            if(num!=0){
                ret++;
            }
        }
        return ret;             
    }    
}