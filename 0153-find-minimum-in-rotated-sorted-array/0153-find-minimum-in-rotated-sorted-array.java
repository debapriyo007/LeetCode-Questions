class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length -1;
        int ans = Integer.MAX_VALUE;
        while(left<= right){
            int mid = (left+right)/2;
            if(nums[left]<= nums[mid]){
                //my left portion is sorted.
                ans = Math.min(ans, nums[left]);
                left = mid+1; //don't need for search other elements.So, update my left pointer.
            }else{
                right = mid-1;
                ans = Math.min(ans, nums[mid]);
            }
        }
        return ans;
    }
}