class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
       
        
        int cnt = 0;
        Set<Character> set = new HashSet<>();
        for(char ch: allowed.toCharArray()){
            set.add(ch);
        }
        
        for(String s : words){
            boolean isContains = true;
            for(char ch : s.toCharArray()){
                if(!set.contains(ch)){
                    isContains = false;
                    break;
                }
            }
            
            if(isContains){cnt++;}
        }
        return cnt;
    }
}