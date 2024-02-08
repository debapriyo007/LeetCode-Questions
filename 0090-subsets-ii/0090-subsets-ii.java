class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //First i have to sort the array.
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        CalSubset(0, nums, ans, new ArrayList<>());
        return ans;
    }
    
     public static void CalSubset(int index, int arr[], List<List<Integer>>ans, List<Integer>list){
         ans.add(new ArrayList<>(list));
         
         for(int i = index;i<arr.length;i++){
             // if  is't to be First and Duplicate then Continue.
             if(i!=index && arr[i] == arr[i-1])continue;
             list.add(arr[i]);
             CalSubset(i+1, arr, ans, list);
             list.remove(list.size()-1);
         }
         
     }
}