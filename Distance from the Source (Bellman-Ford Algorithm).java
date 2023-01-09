https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
https://www.youtube.com/watch?v=0vVofAhAYjc&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=41

TC: O(E * V)
SC: O(E)
  
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist=new int[V];
        for(int i=0;i<V;i++)
            dist[i]=(int) (1e8);
        dist[S]=0;
        
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> x:edges){
                int u=x.get(0);
                int v=x.get(1);
                int wt=x.get(2);
                if(dist[u]!=(1e8) && (dist[u]+wt) < dist[v])
                    dist[v]=dist[u]+wt;
            }
        }
        
        //check for -ve cycle
        //if on the nth iteration we can see dist array is getting updated that means it has a -ve cycle
        for(ArrayList<Integer> x:edges){
            int u=x.get(0);
            int v=x.get(1);
            int wt=x.get(2);
            if(dist[u]!=(1e8) && (dist[u]+wt) < dist[v])
                return new int[]{-1};
        }
        return dist;    
    }
}
