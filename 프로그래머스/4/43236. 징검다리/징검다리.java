import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        List<Integer> points = new ArrayList<>();
        for (int r : rocks) points.add(r);  // 배열 → 리스트 수동 변환
        points.add(0);                      // 출발 지점
        points.add(distance);              // 도착 지점
        Collections.sort(points);          // 정렬 필수

        int left = 1;
        int right = distance; 
        int ret = 0;
        
        
        while(left<=right){          
            int prev=0;
            int removeCount = 0;
            int mid = (left+right)/2;
            for(int i=1;i<points.size();i++){
                int gap = points.get(i)-points.get(prev);
                if(gap<mid){
                    removeCount++;
                }
                else{
                    prev=i;
                }
            }
            if(removeCount>n){
                right = mid-1;
            }
            else{
                ret=mid;
                left=mid+1;
            }
        }
        return ret;
    }
}