class Solution {
    public int search(int[] nums, int target) {
        
        //Initilize two pointer.
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            //best condition if my mid will be my target.
            if(nums[mid] == target)return mid;
            
            //check which portion is sorted left or right ?
            if(nums[left]<=nums[mid]){ //it's means my left portion is sorted.
                if(nums[left]<=target && target< nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                //Right portion is Sorted
                if(nums[mid]<target && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}