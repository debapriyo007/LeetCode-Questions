class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer>pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){ //reverse the natural order and make it max-heap
                return b - a;
            }
        });
        
        for(int ele : nums){
            pq.add(ele);
        }
        
        int x = k-1;
        while(x>0){
            pq.remove();
            x--;
        }
        
        return pq.peek();
    }
}