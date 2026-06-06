// User function Template for Java

class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        // code here
        int n = arr.length;
        int sum =0, res = Integer.MIN_VALUE;
        int st = 0, e=0;
        int fs =0, fe=0;
        for(int i=0;i<n;i++){
            if(arr[i] < 0){
                sum =0;
                st = i+1;
            }
            sum += arr[i];
            if(sum > res){
                e = i;
                res = sum;
                fs = st; fe= e;
            }else if(sum == res){
                e=i;
                int pl = (fe-fs);
                int nl = e-st;
                if(nl > pl){
                    fe = e;
                    fs = st;
                }
            }
            
            
            
            if(sum < 0){
                sum =0;
                st = i+1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
       if(fs > fe){
           ans.add(-1);
           return ans;
       };
        
        for(int i=fs;i<=fe;i++){
            ans.add(arr[i]);
        }
        return ans;
        
    }
}