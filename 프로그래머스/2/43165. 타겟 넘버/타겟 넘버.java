class Solution {
    public int solution(int[] numbers, int target) {
        return findTarget(0,0,numbers,target);        
    }
    private int findTarget(int idx,int now,int[] numbers,int target){
        if(idx ==numbers.length){
            if(now==target) return 1;
            return 0;
        }
        return findTarget(idx+1,now-numbers[idx],numbers,target)+findTarget(idx+1,now+numbers[idx],numbers,target);
    }
}