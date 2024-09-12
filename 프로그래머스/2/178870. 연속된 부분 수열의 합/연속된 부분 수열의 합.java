class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int[] stackSum = new int[sequence.length+1];
        stackSum[0]=0;
        for(int i=1;i<=sequence.length;i++){
            stackSum[i]=sequence[i-1]+stackSum[i-1];
        }
        
        int retS=-1;
        int retE=-1;
        int minLen = 1000001;        
        
        int startIdx=0;// 무조건 0 저장
        int endIdx=1; 
        
        while(endIdx<=sequence.length){
            if(stackSum[endIdx]-stackSum[startIdx]<k){
                endIdx++;
            }
            else if(stackSum[endIdx]-stackSum[startIdx]==k){
                if (endIdx - startIdx < minLen) {
                    minLen = endIdx - startIdx;
                    retS = startIdx;
                    retE = endIdx - 1;
                }
                endIdx++;
            }
            else{
                startIdx++;
            }
        }
        return new int[]{retS,retE};     
    }
}