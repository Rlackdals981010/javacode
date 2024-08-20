class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        int count =  (int)(Math.log10(n)+1);
        answer = new int[count];
        int idx=0;
        while(n!=0){
            answer[idx++]=(int)(n%10);
            n=n/10;
        }
        
        
        return answer;
    }
}