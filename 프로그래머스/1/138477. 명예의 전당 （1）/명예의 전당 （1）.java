import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        ArrayList<Integer> arr = new ArrayList<>();
        Comparator<Integer> comparator = (a,b)->a-b;
        Queue<Integer> pq = new PriorityQueue<>(comparator);
        
        for(int i=0;i<score.length;i++){
            pq.add(score[i]);
            if(pq.size()>k)pq.poll();
            arr.add(pq.peek());          
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}