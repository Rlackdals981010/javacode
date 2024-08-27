class Solution {
    public static boolean[] check;

    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        return dfs(dungeons, k, 0);
    }

    int dfs(int[][] dungeons, int left, int cnt) {
        int maxCount = cnt;
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!check[i] && left >= dungeons[i][0]) {
                check[i] = true;
                maxCount = Math.max(maxCount, dfs(dungeons, left - dungeons[i][1], cnt + 1));
                check[i] = false;  // 상태 복원
            }
        }
        
        return maxCount;
    }
}