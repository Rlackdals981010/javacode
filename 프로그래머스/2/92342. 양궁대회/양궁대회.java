class Solution {
    private int[] optimalShots;
    private int maxScoreDiff = 0;

    public int[] solution(int n, int[] info) {
        optimalShots = new int[11];
        dfs(0, new int[11], n, info);
        
        // 점수 차이가 0 이하이면 라이언이 이길 수 없으므로 -1 반환
        return maxScoreDiff > 0 ? optimalShots : new int[]{-1};
    }

    private void dfs(int depth, int[] lionShots, int remainingArrows, int[] apeachShots) {
        // 모든 점수를 탐색한 경우
        if (depth == 11) {
            // 남은 화살을 0점에 할당
            if (remainingArrows > 0) {
                lionShots[10] += remainingArrows;
            }

            // 점수 차이 계산
            int scoreDiff = calculateScoreDiff(lionShots, apeachShots);
            if (scoreDiff > maxScoreDiff) {
                maxScoreDiff = scoreDiff;
                optimalShots = lionShots.clone(); // 현재 최적의 화살 배분 저장
            } else if (scoreDiff == maxScoreDiff && isBetterChoice(lionShots)) {
                optimalShots = lionShots.clone();
            }

            // 마지막 점수를 탐색한 경우 종료
            if (remainingArrows > 0) {
                lionShots[10] -= remainingArrows; // 남은 화살 원상 복구
            }
            return;
        }

        // 현재 점수를 포기하는 경우 (화살을 쏘지 않는 경우)
        dfs(depth + 1, lionShots, remainingArrows, apeachShots);

        // 현재 점수를 획득하는 경우 (어피치보다 1발 더 쏨)
        if (remainingArrows > apeachShots[depth]) {
            lionShots[depth] = apeachShots[depth] + 1;
            dfs(depth + 1, lionShots, remainingArrows - lionShots[depth], apeachShots);
            lionShots[depth] = 0; // 백트래킹 - 원상 복구
        }
    }

    // 점수 차이 계산
    private int calculateScoreDiff(int[] lion, int[] apeach) {
        int lionScore = 0;
        int apeachScore = 0;
        for (int i = 0; i < 11; i++) {
            if (lion[i] > apeach[i]) {
                lionScore += 10 - i;
            } else if (apeach[i] > 0) {
                apeachScore += 10 - i;
            }
        }
        return lionScore - apeachScore;
    }

    // 더 나은 화살 배분인지 판단 (낮은 점수에 화살이 많을수록 유리)
    private boolean isBetterChoice(int[] newShots) {
        for (int i = 10; i >= 0; i--) {
            if (newShots[i] > optimalShots[i]) return true;
            if (newShots[i] < optimalShots[i]) return false;
        }
        return false;
    }
}
