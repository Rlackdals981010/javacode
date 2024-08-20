class Solution {
    public int[] solution(int brown, int yellow) {
        int y=1,x=1;
        int total = brown + yellow;
        for(int i=2;i<=Math.sqrt(total);i++){
            if(total%i==0){
                y=i;
                x=total/i;
                if((y-2)*(x-2)==yellow){
                    return new int[]{x,y};
                }
            }
        }
        
        if(y>=x)return new int[]{y,x};
        else return new int[]{x,y};
    }
}