class Solution {
    public static int findDay(int arr[], int cap){
        int load = 0; //intit i load 0 item in the ship.
        int days = 1;
        for(int i = 0;i<arr.length;i++){
            if(load + arr[i]>cap){
                //if my load is exceed my capacity.
                //update my days.
                days+=1;
                //load new items
                load = arr[i];
            }else{
                //if my capacity is not full fill.
                // i will load.
                load += arr[i];
                
            }
        }
        return days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        
        //step 1: Find the low and high.
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<weights.length;i++){
            max = Math.max(max, weights[i]);
            sum+= weights[i];
        }
        
        int low = max;
        int high = sum;
        while(low<=high){
            int mid = (low+high)/2;
            // find the number of day to load the ship this capacity
            // mane parameter pass kora mid ta hoya6e capacity , oy capacity full fill korte koto somy lagbe.
            int numOfday = findDay(weights, mid);
            if(numOfday<=days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    // Time Complexity -> 0(log n) * 0(n) = 0(n log n)
    // Space Complexity -> Constant
}