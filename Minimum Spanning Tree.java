https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
https://www.youtube.com/watch?v=mJcZjjKzeqk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=45

class Pair{
    int node;
    int weight;
    Pair(int weight,int node){
        this.weight=weight;
        this.node=node;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    int weightSum=0;
	    ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
	    PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.weight-y.weight);
	    int[] vis=new int[V];
	    for(int i=0;i<V;i++)
	        adj.add(new ArrayList<Pair>());
	        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][2],edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2],edges[i][0]));
        }
        
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int n=pair.node;
            int wt=pair.weight;
            if(vis[n]==0){
                for(Pair x:adj.get(n)){
                    int xn=x.node;
                    int xwt=x.weight;
                    //if(vis[xn]==0){
                        pq.add(new Pair(xwt,xn));
                    //}    
                }
                vis[n]=1;
                weightSum+=wt;
            }
        }
        return weightSum;
	}
}
