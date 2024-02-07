class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
    
    public static void findCombination(int index, int target, int arr[],List<List<Integer>> ans, List<Integer>list){
        
        
        
        //base.
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        
        if(arr[index]<= target){
            list.add(arr[index]);
            //pick condition.
            findCombination(index, target- arr[index], arr, ans, list);
            list.remove(list.size()-1);
        }
        //Non pick condition.
        findCombination(index+1, target, arr, ans, list);
    }
    
}