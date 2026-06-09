class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
       // int [][] res = new int[n][2];
       List<int[]> arr = new ArrayList<>();
        int idx=0;

        int[] temp = intervals[0];
        for(int i=1;i<n;i++){
            if(temp[1] >= intervals[i][0]){
                temp[1] = Math.max(temp[1], intervals[i][1]);
            }else{
                // res[idx]=temp;
                arr.add(temp);
                temp = intervals[i];
                // idx++;
            }
        }
        // res[idx++]= temp;
        arr.add(temp);
        // return Arrays.copyOf(res, idx);
        return arr.toArray(new int[arr.size()][]);
    }
}