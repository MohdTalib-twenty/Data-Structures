class Solution {
    private void Swap(int[][]matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    private void Reverse(int[][] matrix, int i, int m){
        int l=0, h=m-1;
        while(l<h){
            int temp = matrix[i][l];
            matrix[i][l] = matrix[i][h];
            matrix[i][h] = temp;
            l++;h--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                Swap(matrix, i, j);
            }
        }
        for(int i=0;i<n;i++){
            Reverse(matrix, i, m);
        }

    }
}