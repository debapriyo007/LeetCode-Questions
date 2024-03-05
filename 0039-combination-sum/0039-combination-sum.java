class Solution {
    public static void Find(int index, int arr[], int target, List<List<Integer>>ans, List<Integer> ds){
        
        //base case.
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(arr[index]<= target){
            //this is the pick condition.
            ds.add(arr[index]);
            Find(index, arr, target - arr[index], ans, ds); //decrement my target.
            ds.remove(ds.size()-1);
        }
        //non - pick condition.
        Find(index+1, arr, target, ans, ds);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Find(0,candidates,target, ans, new ArrayList<>());
        return ans;
    }
}