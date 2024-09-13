class Solution {
    public int solution(int[] queue1, int[] queue2) {

        int len = queue1.length;
        long sumQueue1 =0,sumQueue2 =0;
        int[] totalQueue = new int[len*2];// 두 큐 이음     
        
        for (int i = 0; i < len; i++) {
            totalQueue[i] = queue1[i];
            sumQueue1 += queue1[i];
            totalQueue[i + len] = queue2[i];           
            sumQueue2 += queue2[i];           
        }
        long total = sumQueue1+sumQueue2;
        
        if(total%2!=0){return -1;}
        
        long target=total/2;
        int s = 0, e = len-1;
        int ret=0;
        long now = sumQueue1;
        
        while(s<=e&&e<totalQueue.length){
            if(now==target){
                return ret;
            }
            else if(now<target){
                e++;
                if (e < totalQueue.length) {  
                    now += totalQueue[e];
                    ret++;
                }
            }
            else{
                now-=totalQueue[s];
                s++;
                ret++;                
            }
        }
        return -1;
    }
}