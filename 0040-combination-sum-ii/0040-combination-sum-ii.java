class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinition(0,candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    public static void findCombinition(int indx, int arr[], int target,List<List<Integer>> ans, List<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = indx;i<arr.length;i++){
            if(i>indx && arr[i] == arr[i-1])continue;
            if(arr[i]>target)break;
            list.add(arr[i]);
            findCombinition(i+1, arr, target-arr[i], ans , list);
            list.remove(list.size()-1);
        }
    }
}