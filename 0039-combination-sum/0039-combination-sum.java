class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        find(0,candidates,target, ans, new ArrayList<>());
        return ans;
    }
    
    
    public static void find(int indx,int[] arr,int target,List<List<Integer>> ans, List<Integer>list){
        
        //BASE CASE.
        if(indx == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        //Thre are two condition here 
        // 1st is :- Pick Condition.
        //2nd is: - Non Pick Condition.
        
        //Pick Condition.
        if(arr[indx]<= target){ //if my target is greater than arr index element
            list.add(arr[indx]); //then add it to my list.
            find(indx, arr, target-arr[indx], ans, list); 
            list.remove(list.size()-1); //when return or backtrack remove the 22 loc which is added.
        }
        find(indx+1, arr, target, ans, list); //Non Pick condition.
    }
}