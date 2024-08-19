class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        //edge case.
        // if(s.length()!= t.length())return false;
        
        //if both len is equal.
//         int cnt1 = 0;
//         int cnt2 = 0;
        
//         for(int i = 0;i<s.length();i++){
//             if(s.charAt(i) == '#'){cnt1++;}
//         }
//          for(int i = 0;i<t.length();i++){
//             if(t.charAt(i) == '#'){cnt2++;}
//         }
//         if(cnt1 == cnt2){return true;}
// 
        return createOrg(s).equals(createOrg(t));
    }
    
    public String createOrg(String str){
        
        int hashCnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1;i>= 0; i--){
            char ch = str.charAt(i);
            if(ch == '#'){
                hashCnt++;
                continue;
            }
            if(hashCnt > 0){
                hashCnt--;
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}