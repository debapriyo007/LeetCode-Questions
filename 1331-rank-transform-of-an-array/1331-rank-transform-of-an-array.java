class Pair implements Comparable<Pair>{
    int ele;
    int indx;
    Pair(int ele, int indx){
        this.ele = ele;
        this.indx = indx;
    }
    
    @Override
    public int compareTo(Pair p2){
        return this.ele - p2.ele; //sort accending order.
    }
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if(n == 0)return new int[0]; //this is give me as runtime error.
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0;i<n;i++){
            pq.add(new Pair(arr[i], i));
        }
        
        int[]ans = new int[n];
        int rank = 1;
        Pair prev = pq.poll(); //get the first smaller ele,indx
        ans[prev.indx] = rank;
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.ele!= prev.ele){
                rank++;
            }
            ans[curr.indx] = rank;
            prev = curr;
        }
        return ans;
    }
}