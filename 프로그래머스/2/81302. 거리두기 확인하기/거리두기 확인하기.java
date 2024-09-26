class Solution {    
    
    static final int[] dy = {-1,0,1,0,-1,1,1,-1,-2,0,2,0};
    static final int[] dx = {0,1,0,-1,1,1,-1,-1,0,2,0,-2};
    
    public int[] solution(String[][] places) {
        
        int[] ret = new int[5];        
        for (int i = 0; i < 5; i++) { // 케이스(방) 분리
            
            char[][] map = new char[5][5]; // 방 테이블
            for (int ii = 0; ii < 5; ii++) {
                map[ii] = places[i][ii].toCharArray();
            }
            
            int addRet = 1;
            outerLoop: // 이중 루프 탈출을 위한 라벨
            for (int y = 0; y < 5; y++) {
                for (int x = 0; x < 5; x++) {
                    if (map[y][x] == 'P') { // 사람이 있는지 확인
                        if (!checkPerson(map, y, x)) { // 하나라도 조건 만족 못하면 탈출
                            addRet = 0;
                            break outerLoop;
                        }
                    }
                }
            }
            
            ret[i] = addRet;
        }
        return ret;
    }
    
    private boolean checkPerson(char[][] map, int y, int x) {
        for (int i = 0; i < 12; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
        
            // 맵 밖은 패스
            if (ny < 0 || nx < 0 || ny > 4 || nx > 4) {
                continue;
            }
        
            // 1칸 거리에서 사람 존재
            if (i <4 && map[ny][nx] == 'P') {
                return false; // 1칸 내에 사람이 있으면 규칙 위반
            }
        
            // 2칸 거리에서 사람 존재
            if (i >= 4 && map[ny][nx] == 'P') {
                if (Math.abs(ny - y) == 2 && map[(y + ny) / 2][x] == 'O') {
                    return false; 
                }
                if (Math.abs(nx - x) == 2 && map[y][(x + nx) / 2] == 'O') {
                    return false; 
                }

                // 대각선인 경우
                if (Math.abs(ny - y) == 1 && Math.abs(nx - x) == 1) {
                    if (map[ny][x] == 'O' || map[y][nx] == 'O') {
                        return false; 
                    }
                }
            }
        }
        return true;
    }

}

