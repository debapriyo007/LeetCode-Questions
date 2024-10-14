class Solution {
    public long maxKelements(int[] nums, int k) {
        
        int n = nums.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
       
        for(int ele : nums){
            pq.offer(ele);
        }
        
        long ans = 0;
        while(k-- > 0){
            int val = pq.poll();
            ans+= val;
            pq.offer((int)Math.ceil(val/3.0));
        }
        return ans;
    }
}

// +++++++++++++++ BRUTE FROCE +++++++++++++++++++++++++++++++++++++++++++++

//         int n = nums.length;
//         long ans = 0;
//         for(int i = 0;i<k;i++){
//            //find the max ele index.
//             int maxIndx = 0;
//             for(int j = 1 ;j<n;j++){
//                 if(nums[j] > nums[maxIndx]){
//                     maxIndx = j;
//                 }
//             }
            
//             ans += nums[maxIndx];
//             //update the maxIndex value.
//             nums[maxIndx] = (int)Math.ceil(nums[maxIndx]/3.0);
            
//         }
//         return ans;