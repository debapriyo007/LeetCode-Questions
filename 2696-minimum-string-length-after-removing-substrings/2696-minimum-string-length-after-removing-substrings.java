class Solution {
    public int minLength(String s) {

        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "");
            s = s.replace("CD", "");
        }
        return s.length();
        
        
//         if(!s.contains("AB") || !s.contains("CD")){
//             return s.length();
//         }
        
//         String ans = recursion(s, "");
//         return ans.length();
    }
    
    String recursion(String s, String ans){
        if(!s.contains("AB") || !s.contains("CD")){
            return ans;
        }
         for(int i = 0;i<s.length();i++){
            if(s.contains("AB") || s.contains("CD")){
                 s = s.replace("AB", "");
                 s = s.replace("CD", "");  
            }
        }
        return recursion(ans, ans+s);
    }
}