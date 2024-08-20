class Solution {
    public int solution(int left, int right) {
        int total=0;
        for(int i=left;i<=right;i++){
            if(i%Math.sqrt(i)==0)total-=i;
            else total+=i;
        }
        return total;
    }
}