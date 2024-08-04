class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int min_x = 52;
        int max_x = -1;
        int min_y = 52;
        int max_y = -1;

        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[i].length();j++){
                if(min_x==52){
                    if(wallpaper[i].charAt(j)=='#'){
                        min_x=i;
                        max_x=i+1;
                        min_y=j;
                        max_y=j+1;
                    }
                }
                else{
                    if(wallpaper[i].charAt(j)=='#'){
                        max_x=Math.max(max_x,i+1);
                        max_y=Math.max(max_y,j+1);
                        min_y=Math.min(min_y,j);
                    }
                }
            }
        }
        return new int[]{min_x,min_y,max_x,max_y};
    }
}