import java.util.ArrayList;
import java.util.Collections;

class Solution {    
    
    static boolean[] visited;
    
    public int solution(int[] cards) {
        visited = new boolean[cards.length];
        ArrayList<Integer> groupSizes = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i++){
            if(!visited[i]){
                int groupSize = open(cards, i);
                groupSizes.add(groupSize);
            }
        }

        Collections.sort(groupSizes, Collections.reverseOrder());

        if (groupSizes.size() < 2) {
            return 0;
        }
        return groupSizes.get(0) * groupSizes.get(1);
    }
    
    private int open(int[] cards, int card){
        if(visited[card]){
            return 0;
        }
        visited[card] = true;
        return 1 + open(cards, cards[card] - 1);
    }
}
