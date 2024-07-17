class Solution {
    public String minWindow(String s, String t) {
        
        // 1st i've to create Frequency map of stirng T.
        HashMap<Character, Integer> FreqMap = new HashMap<>();
        
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            FreqMap.put(ch,FreqMap.getOrDefault(ch, 0)+1);
        }
        
        //No take the variables.
        int unqCnt = FreqMap.size();
        int windSt = 0;
        int windEnd = 0; //i 
        int stIndex  = -1;
        int N = s.length();
        int MinLen = (int)(1e9);
        
        // Expand Phrase.
        while(windEnd < N){
            char ch = s.charAt(windEnd);
            if(FreqMap.containsKey(ch)){
                FreqMap.put(ch,FreqMap.get(ch)-1);
                //after dec the freq if it's 0 means i found so , dec ucc
                if(FreqMap.get(ch) == 0){
                  unqCnt--;  
                }
            }
            // Shrinking Phrase.
            while(unqCnt == 0){
                int len = windEnd - windSt + 1;
                if(len < MinLen){
                    MinLen = len;
                    stIndex = windSt;
                }
                //if present in the map reduce it's value.
                ch = s.charAt(windSt);
                if(FreqMap.containsKey(ch)){
                    FreqMap.put(ch,FreqMap.get(ch)+1);
                     if(FreqMap.get(ch) > 0){
                        unqCnt++;  
                    }   
                }
                 windSt++;
            }
           windEnd++;
        }
        
        return (stIndex == -1) ? "" : s.substring(stIndex, stIndex+MinLen);
    }
}