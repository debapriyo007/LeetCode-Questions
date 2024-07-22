class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        //logic is simple :
        // put hei and name in map.
        //sort the height in ascending order and the max hei will be in the last so corresponding hei string will be taken for map. and put it into ds.
        
        //Time Complexity -> 0(n) + 0(n) = 0(n)
        //Space Complexity-> 0(n)
        
        HashMap<Integer,String> map  = new HashMap<>();
        int n = names.length;
        for(int i = 0;i<n;i++){
            map.put(heights[i],names[i]);
        }
        
        String[]ans = new String[n];
        Arrays.sort(heights);
        int index = 0;
        for(int i = n-1;i>=0;i--){
            ans[index] = map.get(heights[i]);
            index++;
        }
        return ans;
    }
}