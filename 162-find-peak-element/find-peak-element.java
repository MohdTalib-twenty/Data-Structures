class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1)return 0;
        int ans =-1;
        int l =0, h=n-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(m-1 >= 0 && nums[m] > nums[m-1] && m+1 <n && nums[m] > nums[m+1])return m;
            if(m+1<n && nums[m] < nums[m+1])l=m+1;
            else h=m-1;
        }
        if(nums[0] > nums[1])return 0;
        return n-1;
    }
}