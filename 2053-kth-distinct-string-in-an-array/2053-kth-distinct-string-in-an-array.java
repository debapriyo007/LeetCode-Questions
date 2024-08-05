class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : arr){
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        
        // ArrayList<String> list = new ArrayList<>();
        String[]ans = new String[arr.length];
        int index = 0;
        for(String currStr : arr){
            if(map.get(currStr) == 1){
                ans[index] = currStr;
                index++;
            }
        }
        
        return (k>index) ? "" : ans[k-1];
    }
}