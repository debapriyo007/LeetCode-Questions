class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list  = new ArrayList<>();
        partationFun(s, 0, ans, list);
        return ans;
    }
    
    public static void partationFun(String str, int index, List<List<String>> ans, List<String> list){
        
        //base case.
        if(index == str.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        
        for(int i = index;i<str.length();i++){
            if(isPalindrom(str,index, i)){
               list.add(str.substring(index, i+1));
               partationFun(str, i+1, ans, list);
              list.remove(list.size()-1);
            }
           
        }
    }
    
    public static boolean isPalindrom(String str, int si, int ei){
        while(si<=ei){
            if(str.charAt(si++)!=str.charAt(ei--)){
                return false;
            }
        }
        return true;
    }
}