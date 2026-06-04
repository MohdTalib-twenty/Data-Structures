class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n && nums[i] != 1)i++;
        if(i==n)return 0;
        int j=i+1;
        int res= 0;
        while(j<n){
            if(nums[j] == 1)j++;
            else{
                res = Math.max(res,j-i);
                i=j;
                while(i<n && nums[i] != 1)i++;
                j=i+1;
            }
        }
        res = Math.max(res,j-i);
        return res;

    }
}