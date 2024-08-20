import java.util.*;

class hindex {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순 정렬
        int hIndex = 0;

        for(int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) { // 인용 횟수가 h 이상일 때
                hIndex = h;
                break; // 1번 h가 최댓값임
            }
        }

        return hIndex;
    }
}
