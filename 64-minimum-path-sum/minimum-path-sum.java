class Solution {
    int Solve(int i, int j,int[][] grid, List<List<Integer>>dp){

        if(i<0 || j<0)return Integer.MAX_VALUE;
       
        if(i==0 && j==0)return grid[i][j];

        if(dp.get(i).get(j) != -1)return dp.get(i).get(j);

        int res= grid[i][j]+ Math.min(Solve(i-1,j,grid, dp),Solve(i,j-1,grid, dp));

        dp.get(i).set(j,res);
        return res;
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        List<List<Integer>>dp = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer>temp = new ArrayList<>(Collections.nCopies(m,-1));
            dp.add(temp);
        }
        return Solve(n-1,m-1,grid, dp);
    }
}