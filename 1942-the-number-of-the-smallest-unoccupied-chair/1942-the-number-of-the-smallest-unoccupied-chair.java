class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
       
        int targetArrival = times[targetFriend][0];
        
        Arrays.sort(times, new Comparator<int[]>(){
            public int compare(int[]a, int[]b){
                return a[0] - b[0];
            }
        });
        
        //this pq store [livingTime, chairNo]
        PriorityQueue<int[]> occ = new PriorityQueue<>( new Comparator<int[]>(){
            public int compare(int[]a, int[]b){
                return a[0] - b[0];
            }
        });
        
        PriorityQueue<Integer> avai = new PriorityQueue<>();
        int chairNo = 0;
        for(int[]time : times){
            int arrivalTime = time[0];
            int LivingTime = time[1];
            
            //unuccupide those chair which are occupied.
            while(!occ.isEmpty() && occ.peek()[0] <= arrivalTime){
                avai.offer(occ.poll()[1]);
                
            }
            int currentChair;
            if(avai.isEmpty()){
                currentChair = chairNo;
                chairNo++;
            }else{
               currentChair = avai.poll();
            }
            
            if(targetArrival == arrivalTime)return currentChair;
            occ.offer(new int[]{LivingTime, currentChair});
        }
        return -1;
    }
}