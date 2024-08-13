class 카펫 {
    public int[] solution(int brown, int yellow) {
        int total=brown+yellow;
        int a,b;
        int[] ret = new int[2];
        //ret[0]>ret[1]-|
        for(int i=total;i>=Math.sqrt(total);i--){
            if(total%i==0){
                a=i;b=total/a;
                if((a-2)*(b-2)==yellow){
                    ret[0]=a;ret[1]=b;
                    break;
                }
            }
        }
        return ret;
    }
}