class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        
        if(n ==1)return nums[0];
        //check for single element if my single element is present at 0'th index and n-1 index.
        if(nums[0]!=nums[1])return nums[0];
        if(nums[n-1]!= nums[n-2])return nums[n-1];
        
        //take two pointer.
        int low = 1;
        int high = n-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]!= nums[mid-1] && nums[mid]!= nums[mid+1]){
                return nums[mid];
            }
            
            //check where my mid is standing?
            //if my mid is standing odd index.
            //then my left side is even index
            if(mid%2 == 1 && nums[mid] == nums[mid-1]//means i standing in left side but my single element on right side.
              ||(mid%2 == 0 && nums[mid] == nums[mid+1])){ 
                //so what i do ?
                //element the left half.
                low = mid+1;
                
            }else{
                //menas i'm standing on right half
                //but my single element on left half.
                high = mid-1;
            }
        }
        return -1;
    }
}