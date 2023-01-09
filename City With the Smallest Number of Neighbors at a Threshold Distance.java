https://practice.geeksforgeeks.org/problems/city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/1
https://www.youtube.com/watch?v=PwMVNSJ5SLI&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=43

TC: O(N^3)
SC: O(N^2) [Considering distance array]
class Solution {
    int findCity(int n, int m, int[][] edges,int distanceThreshold)
    {
        int[][] cost=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost[i][j]=(int)(1e9);
            }
        }
        
        //forming the cost matrix
        for(int i=0;i<m;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            int wt=edges[i][2];
            cost[from][to]=wt;
            cost[to][from]=wt;
        }
        
        //self loops set to 0
        for(int i=0;i<n;i++)
            cost[i][i]=0;
            
        //updating cost matrix using Floyd Warshall algo
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(cost[i][k]==(int)(1e9) || cost[k][j]==(int)(1e9))
                        continue;
                    cost[i][j]=Math.min(cost[i][j], cost[i][k]+cost[k][j]);
                }
            }
        }
        
        int minCnt=n;
        int cityNo=n-1;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(cost[i][j]<=distanceThreshold)
                    cnt++;
            }
            if(cnt<=minCnt){
                minCnt=cnt;
                cityNo=i;
            }
        }
        return cityNo;
    }
}
