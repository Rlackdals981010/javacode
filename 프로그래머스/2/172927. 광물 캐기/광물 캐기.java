import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalMinerals = Math.min(minerals.length, (picks[0] + picks[1] + picks[2]) * 5);
        int fatigue = 0;
        
        List<int[]> mineralGroups = new ArrayList<>();
        for (int i = 0; i < totalMinerals; i += 5) {
            int[] group = new int[3];
            for (int j = 0; j < 5 && i + j < totalMinerals; j++) {
                if (minerals[i + j].equals("diamond")) {
                    group[0]++;
                } else if (minerals[i + j].equals("iron")) {
                    group[1]++;
                } else if (minerals[i + j].equals("stone")) {
                    group[2]++;
                }
            }
            mineralGroups.add(group);
        }
        
        mineralGroups.sort((a, b) -> (b[0] * 25 + b[1] * 5 + b[2]) - (a[0] * 25 + a[1] * 5 + a[2]));
        
        for (int[] group : mineralGroups) {
            if (picks[0] > 0) {
                picks[0]--;
                fatigue += group[0] * 1 + group[1] * 1 + group[2] * 1;
            } else if (picks[1] > 0) {
                picks[1]--;
                fatigue += group[0] * 5 + group[1] * 1 + group[2] * 1;
            } else if (picks[2] > 0) {
                picks[2]--;
                fatigue += group[0] * 25 + group[1] * 5 + group[2] * 1;
            }
        }
        
        return fatigue;
    }
}


