class Solution
{
    public int solution(int n, int a, int b)
    {
        int round =0;
        // 2로 나눈 몫+ 나머지 가 같으면 같은조
        while(true){
            a=a/2+a%2;
            b=b/2+b%2;
            round++;
            if(a==b){
                break;
            }                
        }
        return round;
    }
}