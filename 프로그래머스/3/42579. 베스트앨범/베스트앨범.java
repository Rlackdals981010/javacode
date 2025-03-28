import java.util.*;
class Solution {
    class Song implements Comparable<Song>{
        int id;
        int play;
        
        Song(int id, int play){
            this.id=id;
            this.play=play;
        }
        
        @Override
        public int compareTo(Song other){
            if(this.play == other.play){
                return this.id-other.id;
            }
            return other.play-this.play;
        }
        
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playSong = new HashMap<>();
        Map<String, List<Song>> Songs = new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            playSong.put(genres[i],playSong.getOrDefault(genres[i],0)+plays[i]);
            Songs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }
        
        List<String> sortedGen = new ArrayList<>(playSong.keySet());
        sortedGen.sort((a,b)-> playSong.get(b)-playSong.get(a));
        
        List<Integer> ret = new ArrayList<>();
        for(String genre : sortedGen){
            List<Song> songList =  Songs.get(genre);
            Collections.sort(songList);
            
            for(int i=0;i<Math.min(2,songList.size());i++){
                ret.add(songList.get(i).id);
            }
        }
        
        return ret.stream().mapToInt(i->i).toArray();
        

    }
}