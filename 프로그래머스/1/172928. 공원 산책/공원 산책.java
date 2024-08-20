class Solution {
    
    static int[] dx = {1, 0, -1, 0}; // 동, 남, 서, 북 방향
    static int[] dy = {0, 1, 0, -1}; // 동, 남, 서, 북 방향
    
    public int[] solution(String[] park, String[] routes) {
        int now_y = 0;
        int now_x = 0;
        
        // 시작 위치 찾기
        for (int y = 0; y < park.length; y++) {
            for (int x = 0; x < park[0].length(); x++) {
                if (park[y].charAt(x) == 'S') {
                    now_y = y;
                    now_x = x;
                    break;
                }
            }
        }
        
        // 명령어 처리
        for (String order : routes) {
            String[] parts = order.split(" ");
            String direction = parts[0];
            int steps = Integer.parseInt(parts[1]);
            int dir = 0;
            
            switch (direction) {
                case "N": dir = 3; break; // 북쪽
                case "E": dir = 0; break; // 동쪽
                case "S": dir = 1; break; // 남쪽
                case "W": dir = 2; break; // 서쪽
            }
            
            boolean blocked = false;
            
            for (int step = 1; step <= steps; step++) {
                int ny = now_y + dy[dir] * step;
                int nx = now_x + dx[dir] * step;
                
                // 경계 조건 확인
                if (ny < 0 || nx < 0 || ny >= park.length || nx >= park[0].length()) {
                    blocked = true;
                    break;
                }
                
                // 장애물 확인
                if (park[ny].charAt(nx) == 'X') {
                    blocked = true;
                    break;
                }
            }
            
            // 만약 장애물에 막히지 않았다면 현재 위치 업데이트
            if (!blocked) {
                now_y += dy[dir] * steps;
                now_x += dx[dir] * steps;
            }
        }
        
        return new int[]{now_y, now_x};
    }
}
