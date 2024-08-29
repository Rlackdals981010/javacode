import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String, Integer> stack = new HashMap<>(); // 누적 시간 저장
        HashMap<String, Integer> record = new HashMap<>(); // 입차 시간 저장
        
        for (String val : records) {
            String[] use = val.split(" ");
            String carNum = use[1]; // 차량 번호를 String으로 처리
            String[] t = use[0].split(":");
            int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);

            if (use[2].equals("IN")) {
                record.put(carNum, time);
            } else {
                int min = time - record.get(carNum);
                record.remove(carNum); // 출차했으므로 기록 제거                
                stack.put(carNum, stack.getOrDefault(carNum, 0) + min);
            }
        }
        
        // 출차 기록이 없는 차량 처리 (23:59 출차로 간주)
        for (String carNum : record.keySet()) {
            int time = 23 * 60 + 59;
            int min = time - record.get(carNum);            
            stack.put(carNum, stack.getOrDefault(carNum, 0) + min);
        }
        
        // 돈 일괄 처리
        for (String carNum : stack.keySet()) {
            int time = 23 * 60 + 59;
            int min = stack.get(carNum);
            int fee = fees[1];
            if (min > fees[0]) {
                int extraTime = min - fees[0];
                int extraFee = (int) Math.ceil((double) extraTime / fees[2]) * fees[3];
                fee += extraFee;
            }
            stack.put(carNum, fee);
        }
        
        
        
        // 차량 번호를 오름차순으로 정렬
        List<String> carNums = new ArrayList<>(stack.keySet());
        Collections.sort(carNums);

        // 최종 요금 배열 생성
        int[] answer = new int[carNums.size()];
        for (int i = 0; i < carNums.size(); i++) {
            answer[i] = stack.get(carNums.get(i));
        }

        return answer;
    }
}
