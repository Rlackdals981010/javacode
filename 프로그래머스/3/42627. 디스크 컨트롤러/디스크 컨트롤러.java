import java.util.*;

class Solution {
    private static class Node implements Comparable<Node> {
        int time;
        int runTime;

        public Node(int time, int runTime) {
            this.time = time;
            this.runTime = runTime;
        }

        @Override
        public int compareTo(Node n) {
            if (this.runTime != n.runTime) return Integer.compare(this.runTime, n.runTime);
            return Integer.compare(this.time, n.time);
        }
    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int now = 0;
        int idx = 0;
        int totalTurnaroundTime = 0;
        int count = jobs.length;

        while (idx < count || !pq.isEmpty()) {

            while (idx < count && jobs[idx][0] <= now) {
                pq.add(new Node(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (!pq.isEmpty()) {
                Node current = pq.poll();
                now += current.runTime;
                totalTurnaroundTime += now - current.time;
            } else {
                now = jobs[idx][0]; 
            }
        }

        return totalTurnaroundTime / count;
    }
}