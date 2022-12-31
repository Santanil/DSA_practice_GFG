https://practice.geeksforgeeks.org/problems/alien-dictionary/1

https://www.youtube.com/watch?v=U3N_je7tWAs&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=26

class Solution
{
    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        return topo;
    }
    
    public String findOrder(String [] dict, int N, int K)
    {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<K;i++)
            adj.add(new ArrayList<>());
            
        //adj list prepared for the graph
        for(int i=0;i<N-1;i++){
            String str1=dict[i];
            String str2=dict[i+1];
            int len=Math.min(str1.length(),str2.length());
            
            for(int j=0;j<len;j++){
                if(str1.charAt(j)!=str2.charAt(j)){
                    adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                    break;
                }
            }
        }
        
        List<Integer> list=topoSort(K,adj);
        String res="";
        
        for(int x:list){
            res=res+(char)(x+(int)('a'));
        }
            
        return res;
    }
}
