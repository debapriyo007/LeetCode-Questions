class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        //This is 2 Pointer approach as well as 
        //The intu is that fixed 1 ele search for other 3 ele
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        
        for(int i = 0;i<n-3;i++){
            
            //Here 3 Sum logic will be apply..
            for(int j = i+1;j<n-2;j++){
                int left = j+1;
                int right = n-1;
                
                while(left<right){
                    long sum = nums[i]+nums[j];
                    sum+= nums[left]+nums[right]; //this for avoide the larger sum.
                    
                    if(sum == target){
                        set.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                    }else if(sum<target){
                       left++; 
                    }else{
                        right--;
                    }
                }
            }
            
        }
        return new ArrayList<>(set);
    }
}