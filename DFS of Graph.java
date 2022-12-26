https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1


class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res, boolean[] vis){
        vis[node]=true;
        res.add(node);
        
        for(Integer x:adj.get(node)){
            if(!vis[x]){
                vis[x]=true;
                dfs(x,adj,res,vis);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res=new ArrayList<>();
        boolean vis[]=new boolean[V];
        vis[0]=true;
        dfs(0,adj,res,vis);
        return res;
    }
}
