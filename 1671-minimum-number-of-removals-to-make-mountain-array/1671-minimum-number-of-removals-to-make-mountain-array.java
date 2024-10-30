class Solution {
    public int minimumMountainRemovals(int[] nums) {
        
        
        int[] lis = new int[nums.length];
        int[] lds = new int[nums.length];

        // For Longest Increasing Subsequence

        solveUsingBS(nums , lis);
        for(int i = 0; i < nums.length / 2 ; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        // For Longest Decreasing Subsequence

        solveUsingBS(nums , lds);
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(lis[i] == 1 || lds[nums.length - 1 -i] == 1){
                continue;
            }
            max = Math.max(max , lis[i] + lds[nums.length - 1 -i] - 1 );
        }       
        return nums.length - max; 
    }
    
    
     void solveUsingBS(int[] nums , int[] lis){
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(nums[0]);
        lis[0] = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(ans.get(ans.size() - 1) < nums[i]){
                ans.add(nums[i]);
                lis[i] = ans.size();
            }else{
                int index = binarySearch(ans , 0 , ans.size() - 1 , nums[i]);
                ans.set(index, nums[i]);
                lis[i] = index + 1;
            }
        }        
    }
     int binarySearch(List<Integer> list , int s , int e , int target){
        while(s < e){
            int mid = (s + e) / 2;
            if(list.get(mid) == target){
                return mid;
            }
            if(list.get(mid) > target){
                e = mid ;
            }else{
                s = mid + 1;
            }
        }
        return s;
    }
}