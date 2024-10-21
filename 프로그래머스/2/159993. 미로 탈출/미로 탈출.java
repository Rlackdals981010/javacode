import java.util.*;

class Solution {

    private final int[] dy = {-1, 0, 1, 0};
    private final int[] dx = {0, 1, 0, -1};

    public int solution(String[] maps) {

        int ret = 0;

        char[][] map = new char[maps.length][maps[0].length()];
        int[] startPoint = null;
        int[] laberPoint = null;

        for (int i = 0; i < map.length; i++) {
            if (maps[i].indexOf('S') >= 0) {
                startPoint = new int[]{i, maps[i].indexOf('S')};
            }
            if (maps[i].indexOf('L') >= 0) {
                laberPoint = new int[]{i, maps[i].indexOf('L')};
            }
            map[i] = maps[i].toCharArray();  
        }

        if (startPoint == null || laberPoint == null) {
            return -1;
        }

        // 레버 찾기
        int distToLaber = bfs(map, startPoint, 'L');
        if (distToLaber == -1) return -1;  

        // 출구 찾기
        int distToExit = bfs(map, laberPoint, 'E');
        if (distToExit == -1) return -1;  

        ret = distToLaber + distToExit;

        return ret;
    }


    private int bfs(char[][] map, int[] start, char target) {
        int[][] checkPoint = new int[map.length][map[0].length];  
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{start[0], start[1]});
        checkPoint[start[0]][start[1]] = 1;  

        while (!que.isEmpty()) {
            int[] val = que.poll();
            int y = val[0];
            int x = val[1];


            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];


                if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length || checkPoint[ny][nx] != 0) {
                    continue;
                }


                if (map[ny][nx] == 'X') {
                    continue;
                }


                if (map[ny][nx] == target) {
                    return checkPoint[y][x];  
                }


                que.offer(new int[]{ny, nx});
                checkPoint[ny][nx] = checkPoint[y][x] + 1;  
            }
        }

        return -1;  
    }
}
