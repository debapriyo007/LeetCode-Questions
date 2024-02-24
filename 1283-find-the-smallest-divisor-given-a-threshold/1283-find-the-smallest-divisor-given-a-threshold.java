class Solution {
    
    //cal culate smallest divisor.
    public static int smD(int arr[], int d){
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += Math.ceil((double)arr[i]/(double)d);
        }
        return sum;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length>threshold)return -1;
        
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            max = Math.max(nums[i], max);
        }
        
       int low = 1;
       int high = max;
    
        while(low<=high){
            int mid = (low+high)/2;
            if(smD(nums, mid) <= threshold ){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}