class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;

        long asum = 0;
        long asumsq = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long val = grid[i][j];
                asum += val;
                asumsq += val * val;
            }
        }

        long N = 1L * n * n;

        long sum = N * (N + 1) / 2;
        long sumq = N * (N + 1) * (2 * N + 1) / 6;

        long temp1 = asum - sum;      // repeated - missing
        long temp2 = asumsq - sumq;   // repeated² - missing²

        temp2 = temp2 / temp1;        // repeated + missing

        int rep = (int) ((temp1 + temp2) / 2);
        int missing = (int) (temp2 - rep);

        return new int[]{rep, missing};
    }
}