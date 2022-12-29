https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
https://www.youtube.com/watch?v=iTBaI90lpDQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=22

TC: O(V+E)
SC: O(2N)
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int cnt=0;  
        int[] indegree=new int[V];
        Queue<Integer> q=new LinkedList<>();
        
        //Update Indegree array
        for(int i=0;i<V;i++){
            for(int x:adj.get(i))
                indegree[x]++;
        }
        
        //Add nodes with indegree 0 to the queue
        for(int i=0;i<V;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        
        //iterate on q and update indegree and keep adding nodes with indegree 0 to the queue
        while(!q.isEmpty()){
            int top=q.poll();
            cnt++;
            for(int x:adj.get(top)){
                indegree[x]--;
                if(indegree[x]==0)
                    q.add(x);
            }
        }
        return !(cnt==V);
    }
}
