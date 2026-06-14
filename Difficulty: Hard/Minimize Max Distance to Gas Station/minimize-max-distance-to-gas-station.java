class Solution {
    class Pair{
        double distance;
        int idx;
        int ck;
        
        
        Pair(double d, int i, int k){
            distance = d;
            idx=i;
            ck =k;
        }
        
        public double getDistance(){
            return this.distance;
        }
         public int getIdx(){
             return this.idx;
         }
         public int getCurrentK(){
             return this.ck;
         }
        
    };
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        if(n==1)return 0;
        // PriorityQueue<List<Integer>>pq = new PriorityQueue<>(
        //     (a,b) -> Integer.compare(b.get(0), a.get(0))
        //     );
        PriorityQueue<Pair>pq = new PriorityQueue<>(
                (a,b) -> Double.compare(b.distance, a.distance)
            );
        for(int i=0;i<n-1;i++){
            double d = Math.abs(stations[i]- stations[i+1]);
            Pair temp  = new Pair(d,i,0);
            pq.add(temp);
        }
        
        while(!pq.isEmpty() && K > 0){
            Pair x = pq.poll();
            double d = x.getDistance(); int  ck = x.getCurrentK(), idx = x.getIdx();
            ck++;
            double nd = (double) (stations[idx+1]-stations[idx])/(ck+1);
            Pair nx = new Pair(nd, idx, ck);
            pq.add(nx);
            K--;
        }
        return pq.peek().getDistance();
    }   
}
