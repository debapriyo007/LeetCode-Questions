class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int n = arr.length;
        int[]copy = new int[n];
        for(int i = 0;i<n;i++){
            copy[i] = arr[i];
        }
        
        Arrays.sort(arr);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int i = 0;i<n;i++){
           if(!map.containsKey(arr[i])){
               map.put(arr[i], rank);
               rank++;
           }
        }
        int[]ans = new int[n];
        for(int i = 0;i<n;i++){
            ans[i] = map.get(copy[i]);
        }
        return ans;
    }
}