class Solution {
    private int First(int[] nums , int n, int target){
        int l= 0, h=n-1;
        int ans = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m] == target){
                ans = m;
                h=m-1;
            }else if(nums[m] > target){
                h=m-1;
            }else l=m+1;
        }
        return ans;
    }
    private int Last(int[] nums , int n, int target){
        int l= 0, h=n-1;
        int ans = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m] == target){
                ans = m;
                l=m+1;
            }else if(nums[m] > target){
                h=m-1;
            }else l=m+1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int f = First(nums, n, target);
        int l = Last(nums, n, target);

        int[] ans = {f,l};
        return ans;
    }
}