class Solution { 

    public int solution(int[] numbers, int target) {
        
        return dfs(numbers,target,0);
       
    }
    
    public int dfs(int[] numbers, int left, int idx){
        
        if(idx==numbers.length){
            return left==0?1:0;
        }
        
        int plus = dfs(numbers,left-numbers[idx],idx+1);
        int minus = dfs(numbers,left+numbers[idx],idx+1);
        
        return plus+minus;        
        
    }
}