class Solution {
    public int solution(int[] numbers, int target) {
        int remain=0;
        for(int num:numbers){
            remain+=num;
        }
        return dfs(numbers,target,0,0,remain);
        
    }
    public int dfs(int[]numbers,int target, int depth, int sum, int remain){
        if(depth==numbers.length){
            if(sum==target){
                return 1;
            }
            else return 0;
        }
        if (Math.abs(sum) > Math.abs(target) + remain) {
            return 0;
        }
        return dfs(numbers,target,depth+1,sum+numbers[depth],remain-numbers[depth])+dfs(numbers,target,depth+1,sum-numbers[depth],remain-numbers[depth]);
    }
    
}
