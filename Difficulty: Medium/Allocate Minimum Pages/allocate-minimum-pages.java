class Solution {
    private boolean isPossible(int[] arr, int m, int k){
        int sum =0;
        int c=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > m)return false;
            sum += arr[i];
            if(sum > m){
                c+=1;
                sum = arr[i];
            }
        }
        return c <= k;
    }
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(n < k)return -1;
        //Arrays.sort(arr);
        int l = Integer.MAX_VALUE, h= 0;
        for(int i=0;i<n;i++){
            l = Math.min(l, arr[i]);
            h += arr[i];
        }
        int ans = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(isPossible(arr,m,k)){
                ans = m;
                h=m-1;
            }else l=m+1;
        }
        return ans;
    }
}