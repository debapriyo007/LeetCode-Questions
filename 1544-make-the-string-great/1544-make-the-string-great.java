class Solution {
    public String makeGood(String s) {
      
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            int len = sb.length();
            if(len > 0 && Math.abs(sb.charAt(len -1) - ch) == 32){
                sb.deleteCharAt(len-1);
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}