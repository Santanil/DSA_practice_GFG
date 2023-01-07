https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
https://www.youtube.com/watch?v=V6H1qAeB-l4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=33

TC: E log V (E-> edges , V-> no of nodes)
class Pair{
    int node;
    int distance;
    Pair(int node,int distance){
        this.node=node;
        this.distance=distance;
    }
}
class Solution
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y) -> x.distance-y.distance);
        
        int[] dist=new int[V];
        for(int i=0;i<V;i++)
            dist[i]=(int)(1e9);
            
        pq.add(new Pair(S,0));
        dist[S]=0;
        
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.node;
            int distance=p.distance;
            
            for(ArrayList<Integer> x:adj.get(node)){
                int n=x.get(0);
                int d=x.get(1);
                
                if(distance+d<dist[n]){
                    pq.add(new Pair(n,(distance+d)));
                    dist[n]=distance+d;
                }
            }
        }
        return dist;
    }
}
