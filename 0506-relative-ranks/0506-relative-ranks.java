class Solution {
    class Pair implements Comparable<Pair>{
        int ele;
        int index;
        
        Pair(int ele, int index){
            this.ele = ele;
            this.index = index;
        }
        
        @Override
        public int compareTo(Pair p2){
           return p2.ele - this.ele; //sort in decending order.
        }
    }
    public String[] findRelativeRanks(int[] score) {
        
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        //add score in pq.
        for(int i = 0;i<score.length;i++){
            pq.add(new Pair(score[i], i));
        }
        
        String[]res = new String[score.length];
        
        int cnt = 1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(cnt == 1){
                res[p.index] = "Gold Medal";
            }else if(cnt == 2){
                res[p.index] = "Silver Medal";
            }else if(cnt == 3){
                res[p.index] = "Bronze Medal";
            }else{
                res[p.index] = String.valueOf(cnt);
            }
            cnt++;
        }
        return res;
    }
}