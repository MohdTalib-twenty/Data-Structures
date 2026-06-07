class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(i-1 >=0 && nums[i] == nums[i-1])continue;
            int l= i+1, h=n-1;
            while(l<h){
                int sum = nums[i]+nums[l]+nums[h];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);temp.add(nums[l]);temp.add(nums[h]);
                    res.add(temp);
                    l++;h--;
                    while(l<h && nums[l]==nums[l-1])l++;
                    while(l<h && nums[h] == nums[h+1])h--;
                }else if(sum > 0)h--;
                else l++;
            }
            
        }
        return res;

    }
}