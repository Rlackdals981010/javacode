import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        List<int[]> events = new ArrayList<>();
        
        for (String[] time : book_time) {
            int startTime = convertTimeToNumber(time[0]);
            int endTime = convertTimeToNumber(time[1]) + 10;
            
            events.add(new int[]{startTime, 1});  // 방 시작 시 +1
            events.add(new int[]{endTime , -1}); // 방 종료 후 청소 완료 시 -1
        }
        
        // 시간순으로 정렬, 동시간의 경우 청소 완료가 먼저
        events.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int maxRooms = 0;
        int roomsInUse = 0;
        
        // 이벤트 순서대로 처리
        for (int[] event : events) {
            roomsInUse += event[1];
            maxRooms = Math.max(maxRooms, roomsInUse);
        }
        
        return maxRooms;
    }

    public static int convertTimeToNumber(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;  // 분 단위로 변환
    }
}


