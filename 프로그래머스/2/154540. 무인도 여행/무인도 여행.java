import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    static boolean[][] check;
    static char[][] map;
    
    static final int[] dy = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static final int[] dx = {0, 1, 0, -1};
    
    public int[] solution(String[] maps) {
        
        // map과 check 배열 초기화
        map = new char[maps.length][maps[0].length()];
        check = new boolean[map.length][maps[0].length()];

        // map에 문자열을 2차원 char 배열로 변환하여 저장
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        // 섬의 시작 좌표 찾기
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (!check[y][x] && map[y][x] != 'X') {
                    // 섬을 발견했을 때 DFS 호출
                    arr.add(dfs(y, x, Character.getNumericValue(map[y][x])));
                }
            }
        }
        
        // 결과 정렬
        Collections.sort(arr);

        // 정렬된 결과를 배열로 변환
        if (arr.size() == 0) {
            return new int[]{-1}; // 섬이 없는 경우 -1 반환
        }
        int[] ret = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ret[i] = arr.get(i);
        }
        return ret;
    }
    
    // DFS 탐색 함수
    private int dfs(int y, int x, int nowTotal) {
        // 현재 위치 방문 표시
        check[y][x] = true;

        // 상하좌우로 탐색
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            // 배열의 경계 체크
            if (ny >= map.length || nx >= map[0].length || ny < 0 || nx < 0) {
                continue;
            }

            // 방문하지 않았고, 'X'가 아닌 곳이면 DFS로 탐색
            if (!check[ny][nx] && map[ny][nx] != 'X') {
                nowTotal += dfs(ny, nx, Character.getNumericValue(map[ny][nx]));
            }
        }
        return nowTotal;
    }
}
