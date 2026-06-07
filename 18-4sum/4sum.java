class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n-3;i++){
            //if(i-1 >=0 && nums[i] == nums[i-1])continue;
            for(int j=i+1;j<n-2;j++){
                //if(j-1 >=0 && nums[j] == nums[j-1])continue;
                long rest = (long)target-(nums[i]+nums[j]);
                int l= j+1, h=n-1;
                while(l<h){
                    long sum = (long) nums[l]+nums[h];
                    if(sum == rest){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[l]);temp.add(nums[h]);
                        st.add(temp);
                        l++;h--;
                        //while(l<h && nums[l]==nums[l-1])l++;
                        //while(l<h && nums[h] == nums[h+1])h--;
                    }else if(sum > rest)h--;
                    else l++;
                }
            }   
        }
        for(List<Integer> x : st){
            res.add(x);
        }
        return res;
    }
}