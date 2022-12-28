https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1


class Element{
    int row,col,dist;
    Element(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
class Solution
{
    public int[][] bfs(int n,int m,Queue<Element> q,int[][] vis,int[][] grid,int[][] dis){
        int[] delRow={-1,0,+1,0};
        int[] delCol={0,+1,0,-1};
        while(!q.isEmpty()){
            Element e=q.poll();
            int r=e.row;
            int c=e.col;
            int d=e.dist;
            
            dis[r][c]=d;
            for(int i=0;i<4;i++){
                int dRow=r+delRow[i];
                int dCol=c+delCol[i];
                
                if(dRow>=0 && dRow<n && dCol>=0 && dCol<m && vis[dRow][dCol]==0){
                    vis[dRow][dCol]=1;
                    q.add(new Element(dRow,dCol,d+1));
                }
            } 
        }
        return dis;
    }
    public int[][] nearest(int[][] grid)
    {
        int r=grid.length;
        int c=grid[0].length;
        Queue<Element> q=new LinkedList<>();
        int[][] vis=new int[r][c];
        int[][] dis=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    vis[i][j]=1;
                    q.add(new Element(i,j,0));
                }
            }
        }
        return bfs(r,c,q,vis,grid,dis);
        
    }
}
