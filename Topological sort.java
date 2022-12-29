https://practice.geeksforgeeks.org/problems/topological-sort/1
https://www.youtube.com/watch?v=5lZ0iJMrUMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=20


TC: O(N+E)
SC: O(N)
class Solution
{   
    static void dfs(int node,int[] vis, Stack<Integer> stk,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        
        for(int x:adj.get(node)){
            if(vis[x]==0)
                dfs(x,vis,stk,adj);
        }
        stk.push(node);
    } 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] sorted=new int[V];
        int[] vis=new int[V];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0)
                dfs(i,vis,stk,adj);
        }
        int x=0;
        while(!stk.isEmpty()){
            sorted[x++]=stk.pop();
        }
        
        return sorted;
    }
}
