import java.util.*;

class Solution {
    public long solution(long n) {
        String[] arr = Long.toString(n).split("");
        Arrays.sort(arr,Collections.reverseOrder());
        String ret = String.join("",arr);
        return Long.parseLong(ret);
    }
}