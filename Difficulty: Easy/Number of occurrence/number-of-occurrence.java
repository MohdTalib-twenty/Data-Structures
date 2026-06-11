class Solution {
    private int First(int[] arr , int n, int target){
        int l= 0, h=n-1;
        int ans = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(arr[m] == target){
                ans = m;
                h=m-1;
            }else if(arr[m] > target){
                h=m-1;
            }else l=m+1;
        }
        return ans;
    }
    private int Last(int[] arr , int n, int target){
        int l= 0, h=n-1;
        int ans = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(arr[m] == target){
                ans = m;
                l=m+1;
            }else if(arr[m] > target){
                h=m-1;
            }else l=m+1;
        }
        return ans;
    }
    int countFreq(int[] arr, int target) {
        // code here
        int n = arr.length;
        int f = First(arr,n,target);
        int l = Last(arr, n, target);
        
        if(l == -1 || f == -1)return 0;
        return l-f+1;
        
    }
}
