import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {

        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = i * columns + j + 1;
            }
        }
        
        int[] ret = new int[queries.length];
        

        for (int i = 0; i < ret.length; i++) {
            ret[i] = spin(map, queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
        }
        
        return ret;
    }

    private int spin(int[][] map, int y1, int x1, int y2, int x2) {
        int min = Integer.MAX_VALUE;       
       
        int temp = map[y1][x1];
        min = Math.min(min, temp);
       
       
        for (int i = y1; i < y2; i++) {
            map[i][x1] = map[i + 1][x1];
            min = Math.min(min, map[i][x1]);
        }
       
       
        for (int i = x1; i < x2; i++) {
            map[y2][i] = map[y2][i + 1];
            min = Math.min(min, map[y2][i]);
        }        
        
        for (int i = y2; i > y1; i--) {
            map[i][x2] = map[i - 1][x2];
            min = Math.min(min, map[i][x2]);
        }
        
        for (int i = x2; i > x1; i--) {
            map[y1][i] = map[y1][i - 1];
            min = Math.min(min, map[y1][i]);
        }       

        map[y1][x1 + 1] = temp;
        
        return min;
    }
}
