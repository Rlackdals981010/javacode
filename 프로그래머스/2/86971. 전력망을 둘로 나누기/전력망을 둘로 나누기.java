import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // 송전탑 연결 상태를 맵에 저장
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            // a -> b 연결 추가
            map.putIfAbsent(a, new ArrayList<>());
            map.get(a).add(b);
            
            // b -> a 연결 추가
            map.putIfAbsent(b, new ArrayList<>());
            map.get(b).add(a);
        }
        
        int minDifference = Integer.MAX_VALUE;
        
        // 각 연결을 끊어보고 크기 비교
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            // a와 b 사이의 연결을 끊음
            map.get(a).remove(Integer.valueOf(b));
            map.get(b).remove(Integer.valueOf(a));
            
            // 하나의 송전탑에서 BFS 또는 DFS로 크기 계산
            int groupSize = bfs(map, 1, n);
            
            // 두 그룹의 크기 차이를 계산
            int otherGroupSize = n - groupSize;
            minDifference = Math.min(minDifference, Math.abs(groupSize - otherGroupSize));
            
            // a와 b 사이의 연결을 복구
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        return minDifference;
    }
    
    // BFS로 연결된 송전탑의 크기를 계산
    private int bfs(Map<Integer, List<Integer>> map, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            
            for (int neighbor : map.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        return count;
    }
}
