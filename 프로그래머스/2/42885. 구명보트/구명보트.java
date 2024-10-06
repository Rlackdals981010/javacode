import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int ret =0;
        Arrays.sort(people);
        int startIdx = 0;
        int endIdx = people.length-1;
        while (startIdx <= endIdx) { 
            if (people[startIdx] + people[endIdx] <= limit) {
                startIdx++; 
            }
            endIdx--;
            ret++; 
        }
        return ret;
        
    }

}