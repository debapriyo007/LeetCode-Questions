class Solution {
    public boolean search(int[] nums, int target) {
      
        
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target)return true;
            
            //handle the duplicate edge case.
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left++;
                right--;
                continue;
            }
            
            //here, check for the sorted portion.
            if(nums[left]<=nums[mid]){ //left portion is sorted
                if(nums[left]<=target && target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{ //right portion
                if(nums[mid]<= target && target < nums[left]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
}