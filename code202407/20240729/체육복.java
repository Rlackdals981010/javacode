import java.util.*;
class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int ret = n - lost.length;
        Arrays.sort(reserve);
        Arrays.sort(lost);

        //여분제거
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    lost[i]=-1;
                    reserve[j]=-1;
                    ret++;
                    break;
                }
            }
        }

        int idx=0;

        //빌려주기
        for(int i=0;i<lost.length;i++){
            for(int j=idx;j<reserve.length;j++){
                if(lost[i]-1==reserve[j]||lost[i]+1==reserve[j]){
                    reserve[j]=-1;
                    lost[i]=-1;
                    ret++;
                    idx=j+1;
                    break;
                }
            }
        }
        return ret;
    }
}