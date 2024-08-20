class Solution {
    public int solution(int n) {
        int answer = 2;
        while(true){
            if((n-1)%answer==0)break;
            answer++;
        }
        
        
        
        
        return answer;
    }
}