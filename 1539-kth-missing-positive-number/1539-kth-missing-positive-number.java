class Solution {
    public int findKthPositive(int[] arr, int k) {
    
/*
       for(int i = 0;i<arr.length;i++){
           if(arr[i]<=k){
               k++;
           }else{
               break;
           }
       }
        return k;
*/
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            // Missing number at each index.
            int missingNum = arr[mid] - (mid+1);
            if(missingNum<k){
               low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low+k;
        
    }
}