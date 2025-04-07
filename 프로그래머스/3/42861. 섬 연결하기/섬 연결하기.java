import java.util.Arrays;
class Solution {
    public int solution(int n, int[][] costs) {
        int ret = 0;   
        int count=0;
        int[] pNode = new int[n];
        for(int i=0;i<n;i++){
            pNode[i]=i;
        }
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        for(int[] cost:costs){
            int node1 = cost[0];
            int node2 = cost[1];
            int price = cost[2];
            if(find(pNode,node1)!=find(pNode,node2)){
                union(pNode,node1,node2);
                ret+=price;
                count++;
            }
            if(count==n-1) break;
            
        }
        return ret;
        
    }
    private int find(int[] pNode, int x){
        if(pNode[x]==x)return x;
        return pNode[x] = find(pNode, pNode[x]);
    }
    private void union(int[] pNode,int a, int b){
        int A = find(pNode,a);
        int B = find(pNode,b);
        if(A!=B){
            pNode[B]=A;
        }
    }

}