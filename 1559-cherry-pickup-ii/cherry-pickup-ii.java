class Solution {
    class Temp{
        int i,j,k;
        Temp(int a, int b, int c){
            i=a;j=b;k=c;
        }
    };

    private int Solve(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp){
        if(i>=n)return 0;

        int temp =0;
        if(dp[i][j1][j2] != -1)return dp[i][j1][j2];
        for(int dj1=-1;dj1<=1;dj1++){
            int nj1 = j1+dj1;
            for(int dj2 =-1;dj2<=1;dj2++){
                int nj2 = j2+dj2;
                if(nj1 <0 || nj2<0 || nj1 >=m || nj2 >=m)temp = Math.max(temp,Integer.MIN_VALUE);
                else if(nj1 == nj2) temp = Math.max(temp, grid[i][nj2]+ Solve(i+1,nj1,nj2,n,m,grid,dp));
                else temp = Math.max(temp, grid[i][nj1]+grid[i][nj2]+Solve(i+1,nj1,nj2,n,m,grid,dp) );
            }
        }
      
        return dp[i][j1][j2] = temp;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Map<Temp, Integer>dp = new HashMap<>();
        int[][][] dp = new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return grid[0][0]+grid[0][m-1]+Solve(1,0,m-1,n,m,grid, dp);
    }
}