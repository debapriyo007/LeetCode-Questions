class Solution {
    public int longestPalindrome(String s) {
        
        if(s.length() == 1)return 1;
        
        // HashSet<Character> set = new HashSet<>();
        int[]set = new int[128];
        int res = 0;
        int oddCnt = 0;
        for(char ch : s.toCharArray()){
            if(set[ch]!=0){ // by default array all index value are 0 in java.
                res+=2;
                // set.remove(ch);
                set[ch] = 0;
                oddCnt--;
            }else{
                // set.add(ch);
                set[ch] = 1;
                oddCnt++;
            }
        }
        
//         if(set.size() > 0){
//             res+= 1;
//         }
        if(oddCnt > 0){res+= 1;}
        return res;
       
        /*HashMap<Character, Integer> map = new HashMap<>();
        int oddCnt = 0;
        int res = 0;
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
            int currFreq = map.get(ch);
            if(currFreq % 2 == 0){
                res+= 2;
                oddCnt--;
            }else{
                oddCnt++;
            }
        }
        if(oddCnt > 0){
            res+= 1;
        }
        return res;*/
        
        
    }
}