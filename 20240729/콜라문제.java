class 콜라문제 {
    public int solution(int a, int b, int n) {
        int ret =0;
        int now = n;
        int rest=0;
        while(now>=a){
            int get = now/a*b;
            rest = now%a;
            ret+=get;
            now=get+rest;
        }
        return ret;

    }
}