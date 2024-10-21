class Solution {
    int maxCnt;
    public int maxUniqueSplit(String s) {
        maxCnt = 0;
        backtrack(0, s, new HashSet<>());
        return maxCnt;
    }
    
    void backtrack(int index, String s, HashSet<String> set){
        int n = s.length();
        if(index == n){
            maxCnt = Math.max(maxCnt, set.size());
            return;
        }
        for(int i = index;i<n;i++){
            String sub = s.substring(index, i+1);
            if(!set.contains(sub)){
                set.add(sub);
                backtrack(i+1, s, set);
                set.remove(sub);
            }
        }
    }
}