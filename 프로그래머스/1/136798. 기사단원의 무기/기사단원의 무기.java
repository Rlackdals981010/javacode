class Solution {
    public int solution(int number, int limit, int power) {
        int iron =0;
        int total=0;
        for(int i=1;i<=number;i++){
            int cnt = getMea(i);
            int weap = (cnt>limit)?power:cnt;
            total+=weap;
        }
        return total;
        
    }
    static int getMea(int num){
        int cnt=0;
        for(int i=1;i<Math.sqrt(num);i++)
            if(num%i==0)cnt++;
        cnt*=2;
        if(num%Math.sqrt(num)==0)cnt++;
        return cnt;
    }
}