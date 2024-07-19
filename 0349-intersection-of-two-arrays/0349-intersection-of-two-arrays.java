class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int elem1:nums1){
            map.put(elem1, map.getOrDefault(elem1, 0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(int i:nums2){
            if(map.containsKey(i)){
                set.add(i);
            }
        }
        
        int res[] = new int[set.size()];
        int i = 0;
        for(Integer ele : set){
            res[i] = ele;
            i++;
        }
        return res;
    }
}