class Solution {
    public int longestPalindrome(String s) {
        
        if(s.length() == 1)return 1;
        
        HashMap<Character, Integer> map = new HashMap<>();
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
        return res;
    }
}