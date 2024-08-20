class Solution {
    public int solution(int angle) {
        double ret = (double)angle/90;
        if(ret<1){return 1;}
        else if(ret==1){return 2;}
        else if(ret==2){return 4;}
        return 3;
    }
}