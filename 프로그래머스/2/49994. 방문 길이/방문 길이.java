import java.util.*;
class Solution {
    
    private static final int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int solution(String dirs) {
        
        int x = 0, y=0;
        Set<Path> visitedPaths = new HashSet<>();
        String directions = "UDRL"; // U=0,D=1,R=2,L=3
        
        for(char com : dirs.toCharArray()){
            int dirIdx = directions.indexOf(com);
            int nx = x + moves[dirIdx][0];
            int ny = y + moves[dirIdx][1];
            
            if (nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5) {
                Path path = new Path(x,y,nx,ny);
                visitedPaths.add(path);
                
                x=nx;
                y=ny;
            }
        }
        return visitedPaths.size();

        
        
        
    }
    class Path{
        int x1,y1,x2,y2;
        
        Path(int x1, int y1, int x2, int y2) {            
            if (x1 > x2 || (x1 == x2 && y1 > y2)) {
                this.x1 = x2;
                this.y1 = y2;
                this.x2 = x1;
                this.y2 = y1;
            } else {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
            }
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Path path = (Path) o;
            return x1 == path.x1 && y1 == path.y1 && x2 == path.x2 && y2 == path.y2;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }
}