class Solution {
    //find max value in the array.
    public static int maximumVal(int arr[]){
        int max = Integer.MIN_VALUE;
        for( int i = 0 ;i<arr.length;i++){
            max = Math.max(max, arr[i]);
        }return max;
    }
    
    public static int calHr(int arr[], int hr){
        int Totalhr = 0;
        for(int i = 0 ;i<arr.length;i++){
            Totalhr+= Math.ceil((double)arr[i]/(double)hr);
        }
        return Totalhr;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; //coz koko at least eat one banana form the piles.
        int high = maximumVal(piles); //koko eat maximum banana , the no of maximum value in the array.
        while(low<=high){
            int mid = (low+high)/2;
            int totalHr = calHr(piles, mid);
            if(totalHr<=h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}