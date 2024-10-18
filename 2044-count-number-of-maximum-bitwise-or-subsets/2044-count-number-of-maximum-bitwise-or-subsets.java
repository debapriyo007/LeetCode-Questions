import java.util.*;

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        // generate all subsets
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        generateSubSet(0, nums, new ArrayList<>(), list);

        ArrayList<Integer> orValues = new ArrayList<>();
        for (ArrayList<Integer> ds : list) {
            int orResult = 0;
            for (int ele : ds) {
                orResult |= ele;  
            }
            orValues.add(orResult);
        }

        int maxOr = Collections.max(orValues);

        int cnt = 0;
        for (int orVal : orValues) {
            if (orVal == maxOr) {
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
