class Solution {
    //Now check for which days bloom is possible.
    public static boolean PossibleBloomDay(int arr[], int day, int m , int k){
        int count = 0;
        int totalBouqForm = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
            }else{
                totalBouqForm += (count/k);
                count = 0;
            }
        }
         totalBouqForm += (count/k);
         return totalBouqForm>=m; //return True | False.
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        // Check for impossible conditions.
        long  totalFlwneedAsBouq = (long)m*k;
        if(totalFlwneedAsBouq>bloomDay.length)return -1;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0;i<bloomDay.length;i++){
            min = Math.min(bloomDay[i], min);
            max = Math.max(bloomDay[i], max);
        }
        
        int low = min;
        int high = max;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(PossibleBloomDay(bloomDay, mid, m, k)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}