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
        
        // 섬의 시작 좌표 
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (!check[y][x] && map[y][x] != 'X') {
                    
                    arr.add(dfs(y, x, map[y][x]-'0'));
                }
            }
        }
        
        
        Collections.sort(arr);

        
        if (arr.size() == 0) {
            return new int[]{-1}; 
        }
        
        int[] ret = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ret[i] = arr.get(i);
        }
        return ret;
    }
    
   
    private int dfs(int y, int x, int nowTotal) {
        
        check[y][x] = true;

        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            
            if (ny >= map.length || nx >= map[0].length || ny < 0 || nx < 0) {
                continue;
            }

            
            if (!check[ny][nx] && map[ny][nx] != 'X') {
                nowTotal += dfs(ny, nx, map[ny][nx]-'0');
            }
        }
        return nowTotal;
    }
}
