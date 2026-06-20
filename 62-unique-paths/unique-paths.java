class Solution {
    int Solve(int i, int j, List<List<Integer>>dp){

        if(i<0 || j<0)return 0;

        if(i==0 && j==0)return 1;

        if(dp.get(i).get(j) != -1)return dp.get(i).get(j);

        int res= Solve(i-1,j, dp)+Solve(i,j-1, dp);

        dp.get(i).set(j,res);
        return res;
    }
    public int uniquePaths(int m, int n) {
        List<List<Integer>>dp = new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer>temp = new ArrayList<>(Collections.nCopies(n,-1));
            dp.add(temp);
        }
        return Solve(m-1,n-1,dp);
    }
}