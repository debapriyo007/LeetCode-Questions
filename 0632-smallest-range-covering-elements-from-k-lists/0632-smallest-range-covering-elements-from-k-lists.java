class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            } 
        });
        
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < k; i++) {
            int minVal = nums.get(i).get(0);
            pq.offer(new int[]{minVal, i, 0});
            max = Math.max(max, minVal);
        }
        
        int[] minRange = {0, Integer.MAX_VALUE};
        
        while(true){
            int[] top = pq.poll();
            int minEle = top[0];
            int listIndex = top[1];
            int eleIndex = top[2];
            
            if(max - minEle < minRange[1] - minRange[0]) {
                minRange[0] = minEle;
                minRange[1] = max;
            }
            if(eleIndex == nums.get(listIndex).size() - 1)break;
            int next = nums.get(listIndex).get(eleIndex + 1);
            pq.offer(new int[]{next, listIndex, eleIndex + 1});
            max = Math.max(max, next);
        }
        return minRange;
    }
}