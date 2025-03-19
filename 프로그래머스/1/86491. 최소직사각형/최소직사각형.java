class Solution {
    public int solution(int[][] sizes) {
        int big = findBig(sizes[0][0],sizes[0][1]);
        int small = findSmall(sizes[0][0],sizes[0][1]);
        
        for(int i=1;i<sizes.length;i++){
            int newBig = findBig(sizes[i][0],sizes[i][1]);
            int newSmall = findSmall(sizes[i][0],sizes[i][1]);
            
            if(big<newBig){
                big=newBig;
            }
            if(small<newSmall){
                small=newSmall;
            }            
            
        }
        return big*small;
        
    }
    private int findBig(int a, int b){
        return a>=b?a:b;
    }
    private int findSmall(int a, int b){
        return a>=b?b:a;
    }
}