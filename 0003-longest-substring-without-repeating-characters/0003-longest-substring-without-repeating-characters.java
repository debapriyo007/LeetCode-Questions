class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int stWindow = 0;
        int endWindow = 0; //i
        int maxLen = Integer.MIN_VALUE;
        // HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(endWindow<s.length()){
            char ch = s.charAt(endWindow);
            // if(set.contains(ch)){
            if(map.containsKey(ch) && map.get(ch) >= stWindow){
                // if present in the set, then i have to remove his previous occ.
                //Shrinking..
                // while(stWindow < endWindow && set.contains(ch)){
                //     set.remove(s.charAt(stWindow));
                //     stWindow++;
                // }
                
                
                //update windowSt.
                stWindow = map.get(ch) +1;
            }
            // set.add(ch);
            map.put(ch,endWindow);
            maxLen = Math.max(maxLen, endWindow - stWindow + 1);
            endWindow++;
        }
        return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
    }
}