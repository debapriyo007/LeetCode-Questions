class Solution {
    public int countMaxOrSubsets(int[] nums) {
        // generate all subsets
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        generateSubSet(0, nums, new ArrayList<>(), ansList);
        
        //go through all list of sublist and get ele and perfrom or oprations.
        ArrayList<Integer> binary = new ArrayList<>();
        for(ArrayList<Integer> it : ansList){
        //   System.out.println("SubList : - > " + it);
            int OR = 0;
            for(int ele : it){
        //  System.out.println("SubList Elements - > " + ele);
                OR |= ele;  
            }
            binary.add(OR);
        }
        //	System.out.println(binary);
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
