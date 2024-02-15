class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int [2];
        res[0] = firstPos(nums, target);
        res[1] = LastPos(nums, target);
        return res;
    }
    
    //find fist pos.
    public static int firstPos(int nums[], int target){
        int si = 0;
        int ei = nums.length -1;
        int fo =-1;
        while(si<=ei){
            int mid = si+(ei-si)/2;
            if(nums[mid] ==  target){
               fo = mid;
                ei = mid-1;
            }else if(nums[mid] < target){
                si = mid+1;
            }else{
                ei  = mid-1;
            }
        }return fo;
    }
    
    public static int LastPos(int nums[], int target){
        int si = 0;
        int ei = nums.length -1;
        int lo =-1;
        while(si<=ei){
            int mid = si+(ei-si)/2;
            if(nums[mid] ==  target){
               lo = mid;
                si = mid+1;
            }else if(nums[mid] < target){
                si = mid+1;
            }else{
                ei  = mid-1;
            }
        }return lo;
    }
    
}