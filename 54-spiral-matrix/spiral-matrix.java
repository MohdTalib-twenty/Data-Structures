class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int rs=0,re=n-1,cs=0,ce=m-1;
        List<Integer> res = new ArrayList<Integer>();
        while(rs<=re && cs<=ce){
            for(int j= cs; j<=ce;j++){
                res.add(matrix[rs][j]);
            }
            rs++;
            if(ce >= cs){
               for(int i= rs; i<=re;i++){
                    res.add(matrix[i][ce]);
                }
                ce--;
            }
            if(re >= rs){
                for(int j= ce; j>=cs;j--){
                    res.add(matrix[re][j]);
                }
                re--;
            }
            if(ce >= cs){
               for(int i= re; i>=rs;i--){
                    res.add(matrix[i][cs]);
                }
                cs++;
            }

        }
        return res;
    }
}