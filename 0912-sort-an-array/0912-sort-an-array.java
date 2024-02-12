class Solution {
    public int[] sortArray(int[] nums) {
        merge(nums, 0, nums.length-1);
        return nums;
    }
    
    public static void merge(int arr[], int low, int high){
        if(low>=high){
            return;
        }
        int mid = (low + high)/2;
        merge(arr, low, mid);
        merge(arr, mid+1, high);
        
        mergeBoth(arr, low,  high, mid);
    }
    
    public static void mergeBoth(int arr[], int low, int high, int mid){
        
        int left = low;
        int right   = mid+1;
        ArrayList<Integer> list = new ArrayList<>();
        while(left<= mid && right<= high){
            if(arr[left] <= arr[right]){
                list.add(arr[left]);
                left++;
            }else{
              list.add(arr[right]);
                right++;
            }
        }
        
        //if any element left.
        while(left<= mid){
           list.add(arr[left]);
                left++; 
        }
        while(right<= high){
           list.add(arr[right]);
                right++; 
        }
        
        //last move the element arraylist from array.
        for(int i = low ;i<=high;i++){
            arr[i] = list.get(i - low);
        }
    }
}