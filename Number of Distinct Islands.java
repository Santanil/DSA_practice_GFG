https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1
https://www.youtube.com/watch?v=7zmgQSJghpo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=16


class Solution {
    private static void dfs(int r,int c,int n,int m,int[][] vis,ArrayList<String> list,int[][] grid,int row0,int col0){
        vis[r][c]=1;
        int[] delRow={-1,0,+1,0};
        int[] delCol={0,+1,0,-1};
        list.add(toString(r-row0,c-col0));
        for(int i=0;i<4;i++){
            int dRow=r+delRow[i];
            int dCol=c+delCol[i];
            if(dRow>=0 && dRow<n && dCol>=0 && dCol<m && vis[dRow][dCol]==0 && grid[dRow][dCol]==1){
                vis[dRow][dCol]=1;
                dfs(dRow,dCol,n,m,vis,list,grid,row0,col0);
            }
        }
        
    }
    private static String toString(int r,int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }
    int countDistinctIslands(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][] vis=new int[n][m];
        HashSet<ArrayList<String>> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ArrayList<String> list=new ArrayList<>();
                    dfs(i,j,n,m,vis,list,grid,i,j);
                    hs.add(list);
                }    
            }
        }
        return hs.size();
    }
}
