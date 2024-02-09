class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        
       /*
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean frq[] = new boolean[nums.length];
        findPermutation(nums, ans, list, frq);
        
        */
        
        
        List<List<Integer>> ans = new ArrayList<>();
        Find(0, nums, ans);
        
        return ans;
        
    }
    /*
    public static void findPermutation(int arr[], List<List<Integer>> ans, List<Integer> list, boolean frq[]){
        //base case.
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0;i<arr.length;i++){
            if(!frq[i]){ // if frq array is non-mark.
                //then pick it.
                //mark as true.
                frq[i] = true;
                list.add(arr[i]); //add the ele from array in my list.
                //now i recursively call from others.
                findPermutation(arr, ans, list, frq);
                //now when i return back i remove the last insert element from array.
                list.remove(list.size()-1);
                //mark frq array as false.
                //coz i going one step upward.
                frq[i] = false;
            }
        }
    }
    */
    
    
    public static void swap(int i, int j , int arr[]){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
    
    public static void Find(int index, int arr[],  List<List<Integer>> ans){
        //base case.
        if(index == arr.length){ //if my index size is reach length 
            //creating a new list ans add that list into my ans list.
           ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0;i<arr.length;i++){
                list.add(arr[i]);
            }
            ans.add(new ArrayList<>(list)); //here add in ans list.
            return;
        }
        
        for(int i = index;i<arr.length;i++){
            swap(i, index, arr); //swap loop varriable with curr position.
            Find(index+1, arr, ans); //call for next ele.
            swap(i, index, arr);
        }
    }
    
}