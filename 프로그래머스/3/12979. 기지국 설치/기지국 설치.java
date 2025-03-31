class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1; // 왼쪽 w, 오른쪽 w, 중앙 1 
        int position = 1; 
        
        for (int station : stations) {
            // station의 커버 범위 
            int start = station - w;
            int end = station + w;

            // 지금 위치가 커버 범위보다 앞에 있으면 
            if (position < start) {
                int gap = start - position; // 지금 위치와 start의 간격
                answer += (gap + range - 1) / range; // 올림 나눗셈. 원래는 gap/range의 올림
            }
            position = end + 1;
        }
        
        // 마지막 기지국 이후 커버 안된 구간
        if (position <= n) {
            int gap = n - position + 1;
            answer += (gap + range - 1) / range;
        }
        
        return answer;
    }
}