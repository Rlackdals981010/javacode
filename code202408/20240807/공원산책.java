class 공원산책 {

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

        for (String order : routes) { //명령어
            String[] parts = order.split(" ");
            String direction = parts[0]; //ESWN
            int steps = Integer.parseInt(parts[1]); //숫자
            int dir = 0;

            switch (direction) {
                case "N": dir = 3; break;
                case "E": dir = 0; break;
                case "S": dir = 1; break;
                case "W": dir = 2; break;
            }

            boolean blocked = false;

            for (int step = 1; step <= steps; step++) { //한칸씩 전진하면서 아래 검증
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
