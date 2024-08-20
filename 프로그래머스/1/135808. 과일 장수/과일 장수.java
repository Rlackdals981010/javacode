import java.util.*;
class Solution {
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