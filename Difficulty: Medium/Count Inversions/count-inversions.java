class Solution {
    public static long res=0;
    private static void Merger(int[] arr, int l, int m, int h){
        int i=l,j=m+1;
        List<Integer>temp = new ArrayList<>();
        while(i<=m && j<=h){
            if(arr[i] > arr[j]){
                res += (m-i+1);
                temp.add(arr[j]);
                j++;
            }else{
                temp.add(arr[i]);
                i++;
            }
        }
        while(i<=m){
            temp.add(arr[i]);
            i++;
        }
        while(j<=h){
            temp.add(arr[j]);
            j++;
        }
        for( i=l;i<=h;i++){
            arr[i] = temp.get(i-l);
        }
    }
    private static void Merge(int[] arr,int l, int h ){
        if(l>=h)return ;
        int m = l+(h-l)/2;
        Merge(arr,l,m);
        Merge(arr,m+1, h);
        Merger(arr,l,m, h);
    }
    static int inversionCount(int arr[]) {
        // Code Here
        int n = arr.length;
        res=0;
        Merge(arr,0,n-1);
        return (int)res;
    }
}