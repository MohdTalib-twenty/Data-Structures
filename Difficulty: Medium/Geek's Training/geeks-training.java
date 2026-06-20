class Solution {
    private int Solve(int i, int sr, int n, int mat[][], List<List<Integer>>dp){
        if(i>=n)return 0;
        if(dp.get(i).get(sr) != -1)return dp.get(i).get(sr);
        int res = Integer.MIN_VALUE;
        for(int j=0;j<3;j++){
           if(j != sr) res = Math.max(res, mat[i][j]+Solve(i+1,j,n,mat,dp));
        }
        dp.get(i).set(sr, res);
        return res;
    }
    public int maximumPoints(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        
         List<List<Integer>>dp = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer>temp = new ArrayList<>(Collections.nCopies(3, -1));
            dp.add(temp);
        }
        
        int f = mat[0][0]+ Solve(1,0,n,mat, dp);
        int s = mat[0][1]+ Solve(1,1,n,mat, dp);
        int t = mat[0][2]+ Solve(1,2,n,mat, dp);
        
       
        
        return Math.max(f,Math.max(s,t));
    }
}