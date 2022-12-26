https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class Solution {
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int vis[]=new int[V];
        vis[0]=1;
        q.add(0);
        
        while(!q.isEmpty()){
            int top=q.poll();
            res.add(top);
            
            for(int i=0;i<adj.get(top).size();i++){
                int temp=adj.get(top).get(i);
                if(vis[temp]==0){
                    vis[temp]=1;
                    q.add(temp);
                }
            }
        }
        
        return res;
    }
}
