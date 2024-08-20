import java.io.*;
import java.util.*;
class Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("*");
        }
        for(int i=0;i<m;i++){
            System.out.println(sb.toString());
        }
        
    }
}