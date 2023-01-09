https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
https://www.youtube.com/watch?v=YbY8cVwWAvw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=42


TC: O(N^3)
SC: O(N^2)  [considering the matrix provided, else O(1)]

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1)
                    matrix[i][j]=(int) (1e9);
                if(i==j)
                    matrix[i][j]=0;
            }
        }
        
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]= Math.min( matrix[i][j] , matrix[i][via]+matrix[via][j]);
                }
            }
        }
        
        //if asked to detect -ve cycle use the following block
        for(int i=0;i<n;i++){
            if(matrix[i][i]<0)
                System.out.println("-ve cycle exist");
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==(int)(1e9))
                    matrix[i][j]=-1;
                if(i==j)
                    matrix[i][j]=0;
            }
        }
    }
}
