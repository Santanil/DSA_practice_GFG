https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

class Pair{
    int element;
    int parent;
    Pair(int element,int parent){
        this.element=element;
        this.parent=parent;
    }
}
class Solution {
    public static boolean bfs(int start,int[] vis,ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q=new LinkedList<>();
        vis[start]=1;
        q.add(new Pair(start,-1));
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int val=p.element;
            int par=p.parent;
            
            
            for(int x: adj.get(val)){
                if(vis[x]==0){
                    vis[x]=1;
                    q.add(new Pair(x,val));
                }
                else if(x!=par)
                    return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis=new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(bfs(i,vis,adj))
                    return true;
            }
        }
        return false;
    }
}
