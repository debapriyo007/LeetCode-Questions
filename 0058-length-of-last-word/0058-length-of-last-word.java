class Solution {
    public int lengthOfLastWord(String s) {
        
        String[]words = s.split(" ");
        String last =  words[words.length-1];
        return last.length();
        
    }
}