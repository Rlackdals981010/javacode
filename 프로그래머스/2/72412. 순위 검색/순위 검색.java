import java.util.*;

class Solution {
    // 1. 조건 문자열을 숫자로 매핑
    static Map<String, Integer> lan = Map.of("cpp", 0, "java", 1, "python", 2);
    static Map<String, Integer> pos = Map.of("backend", 0, "frontend", 1);
    static Map<String, Integer> his = Map.of("junior", 0, "senior", 1);
    static Map<String, Integer> food = Map.of("chicken", 0, "pizza", 1);

    // 2. db : 비트마스크를 key로, 점수 리스트를 value로
    static Map<Integer, List<Integer>> db = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        // info 처리
        for (String s : info) {
            String[] arr = s.split(" ");
            int bit = encode(arr[0], arr[1], arr[2], arr[3]);
            int score = Integer.parseInt(arr[4]);
            db.computeIfAbsent(bit, k -> new ArrayList<>()).add(score);
        }

        // 각 점수 리스트 정렬 (이진 탐색 위해)
        for (List<Integer> list : db.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];

        // query 처리
        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].replaceAll(" and ", " ").split(" ");
            List<Integer> bits = getBits(q);
            int targetScore = Integer.parseInt(q[4]);

            int count = 0;
            for (int b : bits) {
                if (db.containsKey(b)) {
                    List<Integer> list = db.get(b);
                    count += list.size() - lowerBound(list, targetScore);
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    // lan, pos, his, food 조합을 하나의 비트마스크 정수로 변환
    private int encode(String l, String p, String h, String f) {
        return (lan.get(l) << 6) | (pos.get(p) << 5) | (his.get(h) << 4) | (food.get(f) << 3);
    }

    // query 읽고, 와일드카드(-)를 고려해서 가능한 모든 비트마스크 조합을 리스트로 뽑음
    private List<Integer> getBits(String[] q) {
        List<Integer> bits = new ArrayList<>();
        dfs(0, 0, q, bits);
        return bits;
    }

    // 조건을 바탕으로 가능한 모든 조합 생성 (재귀)
    private void dfs(int idx, int bit, String[] q, List<Integer> bits) {
        if (idx == 4) {
            bits.add(bit);
            return;
        }

        Map<String, Integer>[] maps = new Map[]{lan, pos, his, food};

        if (q[idx].equals("-")) {
            for (int val : maps[idx].values()) {
                dfs(idx + 1, bit | (val << (6 - idx)), q, bits);
            }
        } else {
            dfs(idx + 1, bit | (maps[idx].get(q[idx]) << (6 - idx)), q, bits);
        }
    }

    // 정렬된 점수 리스트 안에서 target 이상이 처음 등장하는 위치 찾기
    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
}