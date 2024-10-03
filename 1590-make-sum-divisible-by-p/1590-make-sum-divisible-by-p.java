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
        
        // Traverse the array and track prefix sums modulo p
        for (int i = 0; i < n; i++) {
            currentMod = (currentMod + nums[i]) % p;
            int targetMod = (currentMod - totalSum + p) % p;
            
            // Check if we've seen the required mod before
            if (map.containsKey(targetMod)) {
                minLength = Math.min(minLength, i - map.get(targetMod));
            }
            
            // Store the current prefix mod and index
            map.put(currentMod, i);
        }
        
        return minLength == n ? -1 : minLength;
    }
}
