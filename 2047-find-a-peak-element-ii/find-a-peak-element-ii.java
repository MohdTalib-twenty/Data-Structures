class Solution {
    private int MaxAtColumn(int[][] mat, int c){
        int n = mat.length;
        int res = Integer.MIN_VALUE;
        int idx =-1;
        for(int i=0;i<n;i++){
            if(mat[i][c] > res){
                res = mat[i][c];
                idx =i;
            }
        }
        return idx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int l =0,h=m-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            int c = mid, i = MaxAtColumn(mat, mid);
            if( (c-1 < 0 || ( c-1 >= 0 && mat[i][c-1] < mat[i][c] )) && (c+1 >= m || 
            ( c+1 < m && mat[i][c+1] < mat[i][c])) ){
                int[] res = {i,c};
                return res;
            }else if(c-1 >=0 && mat[i][c-1] < mat[i][c]) l=mid+1;
            else h= mid-1;
        }
        int[] res = {-1,-1};
        return res;
    }
}