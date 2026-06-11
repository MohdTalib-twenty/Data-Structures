class Solution {
    private int findMin(int[] arr) {
        int n = arr.length;
        int l=0,h=n-1;
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(arr[m] >= arr[0]){
               if(ans > arr[0]){
                   ans = arr[0];
                   idx = 0;
               }
                l=m+1;
            }else{
                // ans = Math.min(ans, nums[m]);
                if(ans > arr[m]){
                   ans = arr[m];
                   idx = m;
               }
                h=m-1;
            }
        }
        return idx;
    }
    public int findKRotation(int arr[]) {
        // Code here
        int x = findMin(arr);
        int n = arr.length;
        return x;
        
    }
}