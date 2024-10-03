class Solution {
    public int minSubarray(int[] nums, int p) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }
        
        //edge case
        if (totalSum == 0) return 0;
        
        int n = nums.length;
        int minLength = n;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 
        
        int currentMod = 0;
        

        for (int i = 0; i < n; i++) {
            currentMod = (currentMod + nums[i]) % p;
            int targetMod = (currentMod - totalSum + p) % p;
            
            if (map.containsKey(targetMod)) {
                minLength = Math.min(minLength, i - map.get(targetMod));
            }
       
            map.put(currentMod, i);
        }
        
        return minLength == n ? -1 : minLength;
                
        
//         long sum = 0;
//         for(int ele : nums){
//             sum+= ele;
//         }
        
//         //if the sum is less than p, return -1
//         if (sum < p) return -1;
//         //if the whole sum is divided by p return 0.
//         if(sum % p == 0)return 0;
        
//         int n = nums.length;
//         int ans = Integer.MAX_VALUE; 
        
//         //remove subarray and check the rest of sum is devide by p or not..
//         for(int i = 0;i<n;i++){
//             int subArraySum = 0;
//             for(int j = i;j<n;j++){
//                 subArraySum+= nums[j];
//                 if((sum - subArraySum)%p == 0){
//                    ans = Math.min(ans, j-i+1); 
//                 }
//             }
//         }
//         return (ans == Integer.MAX_VALUE) ? -1 : ans;
//      }
    
    
    }
}
