import java.util.*;

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        // generate all subsets
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        generateSubSet(0, nums, new ArrayList<>(), list);
        
        //go through all list of sublist and get ele and perfrom or oprations.
        ArrayList<Integer> binary = new ArrayList<>();
        for(ArrayList<Integer> ds : list){
            int OR = 0;
            for(int ele : ds){
                OR |= ele;  
            }
            binary.add(OR);
        }

        int max = Integer.MIN_VALUE; 
        for(int ele : binary){
            max = Math.max(ele, max);
        }

        int cnt = 0;
        for(int ele : binary){
            if(ele == max){
                cnt++;
            }
        }
        return cnt;
    }

    
     void generateSubSet(int index, int[] arr, 
                         ArrayList<Integer> ds, 
                         ArrayList<ArrayList<Integer>> list) {

        if (index == arr.length) {
            list.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[index]);
        generateSubSet(index + 1, arr, ds, list);

        ds.remove(ds.size() - 1);
        generateSubSet(index + 1, arr, ds, list);
    }
}
