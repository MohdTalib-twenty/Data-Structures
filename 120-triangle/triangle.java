class Solution {
    int Solve(int i, int j, int n, List<List<Integer>>triangle, List<List<Integer>>dp ){
        if(i>=n)return 0;
        
        int m = triangle.get(i).size();
        // if(j>=m)return Integer.MAX_VALUE;

        if(dp.get(i).get(j) != -100000000)return dp.get(i).get(j);
        int f = triangle.get(i).get(j)+Solve(i+1,j,n, triangle,dp);
        int s = triangle.get(i).get(j)+Solve(i+1,j+1,n,triangle,dp);
        int res = Math.min(f,s);
        dp.get(i).set(j, res);
        return res;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==1)return triangle.get(0).get(0);
        List<List<Integer>>dp = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer>temp = new ArrayList<>(Collections.nCopies(201,-100000000));
            dp.add(temp);
        }
        return Solve(0,0,n,triangle, dp);
    }
}