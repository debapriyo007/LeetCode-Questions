class Solution {
    public int mySqrt(int x) {
        
        int low = 1;
        int high = x;
        long ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            long val = (long)mid*(long)mid;
            if(val<=x){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return (int)ans;
    }
}