class Solution {
    int maxLength(int arr[]) {
        // code here
        int n = arr.length;
        int sum =0;
        int res=0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum == 0)res = i+1;
            else if(mp.containsKey(sum)){
                res = Math.max(res, i-mp.get(sum));
            }
            
            if(!mp.containsKey(sum)){
                mp.put(sum, i);
            }
        }
        return res;
    }
}