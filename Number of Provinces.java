https://practice.geeksforgeeks.org/problems/number-of-provinces/1
https://www.youtube.com/watch?v=ACzkVtewUYA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=7

class Solution {
    
    static public void bfsOfGraph(int start, ArrayList<ArrayList<Integer>> adj,int[] vis) {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis[start]=1;
        
        
        while(!q.isEmpty()){
            int temp=q.poll();
            
            for(int x:adj.get(temp)){
                if(vis[x]==0){
                    q.add(x);
                    vis[x]=1;
                }
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> ad, int V) {
        int cnt=0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(ad.get(i).get(j)==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int[] vis=new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                cnt++;
                bfsOfGraph(i,adj,vis);
            }
        }
        
        return cnt;
    }
}
