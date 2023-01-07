https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1
https://www.youtube.com/watch?v=U5Mw4eyUmw4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=36

class Node{
    int row;
    int col;
    int distance;
    Node(int row,int col,int distance){
        this.row=row;
        this.col=col;
        this.distance=distance;
    }
}
class Solution {

        int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0]==destination[0]  &&  source[1]==destination[1])
            return 0;
        Queue<Node> q=new LinkedList<>();
        int r=grid.length;
        int c=grid[0].length;
        int[] dRow={-1,0,+1,0};
        int[] dCol={0,+1,0,-1};
        int[][] dist=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dist[i][j]=(int) (1e9);
            }
        }

        q.add(new Node(source[0],source[1],0));
        dist[source[0]][source[1]]=0;
        
        while(!q.isEmpty()){
            Node n=q.poll();
            int row=n.row;
            int col=n.col;
            int dis=n.distance;
    
            for(int i=0;i<4;i++){
                int delRow=row+dRow[i];
                int delCol=col+dCol[i];
  
                if(delRow>=0 && delRow<r && delCol>=0 && delCol<c && grid[delRow][delCol]==1 && (dis+1)<dist[delRow][delCol]){
                    
                    dist[delRow][delCol]=dis+1;
                    if(delRow==destination[0] && delCol==destination[1])
                        return dis+1; 
                    q.add(new Node(delRow,delCol,dis+1));
                }
            }
        }
        return -1;
    }
}
