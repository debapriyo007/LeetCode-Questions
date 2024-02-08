class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        
        find(0, target,candidates, ans, new ArrayList<>());
        return ans;
        
    }
    
    // Find Combinition SUm Methord.
    public static void  find(int index, int target, int arr[],List<List<Integer>> ans,List<Integer> list){
        
        //base case.
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = index;i<arr.length;i++){
            
            //check for the repeated element.
            //in question it say's that -- Each number in candidates may only be used once in the combination.
            
            //if repeated then i not gonna pick that, so continue..
            if(i>index && arr[i] == arr[i-1] )continue; //i>index means the fist element i don't care duplicate or not.
            if(arr[i]>target)break; //menas  arr[i] value is greater then i gonna break don't pick anything. don't excute anything.
            
            //if i pick.
            list.add(arr[i]);
            
            find(i+1, target - arr[i], arr, ans, list);
            list.remove(list.size()-1);
        }
    }
}