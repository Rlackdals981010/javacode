import java.util.*;
class 과일장수 {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int idx=score.length-1;
        int ret=0;
        while(idx >= m - 1){
            ret += score[idx - m + 1] * m;
            idx -= m;
        }
        return ret;
    }
}

//import java.util.*;
//class Solution {
//    public int solution(int k, int m, int[] score) {
//        Arrays.sort(score);
//        int idx=score.length-1;
//        int ret=0;
//        while(true){
//            idx=idx-(m-1);
//            if(idx<0)break;
//            ret+= score[idx]*m;
//        }
//        return ret;
//    }
//}