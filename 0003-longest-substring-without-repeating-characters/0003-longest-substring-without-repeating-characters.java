/*

    Time Complexity -> 0(2*N)
    Space Complexity -> 0(N)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0)return 0;
        int ans = 1;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        
        while(right<s.length()){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }else{
                set.add(s.charAt(right));
                right++;
                int len = set.size();
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}