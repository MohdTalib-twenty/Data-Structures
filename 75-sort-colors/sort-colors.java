class Solution {
    private void Swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l=0,m=0,h=n-1;
        while(m<=h){
            if(nums[m] == 2){
                Swap(nums, m, h);
                h--;
            }else if(nums[m] == 0){
                Swap(nums, m, l);
                l++;m++;
            }else m++;
        }
    }
}