class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer>st = new HashSet<>();
        for(int i=0;i<n;i++)st.add(nums[i]);
        int res = 0;
        for(int x : st){
            if(st.contains(x-1))continue;
            else{
                int s = x;
                int temp = 1;
                while(st.contains(x+1)){
                    x++;
                    temp++;
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }
}