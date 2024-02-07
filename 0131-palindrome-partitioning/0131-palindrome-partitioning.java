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
        
        
        for(int i = index;i<str.length();i++){ //Why (i =index) coz base on index i want to partation , and go on till the end.
            
            //Suppose , we partation at O'th index
            // check , partation left part sunbstring is palindrom or not ? means (0-0) substring is palindrom or not?
            
            //If palindrom what we do ?
            if(isPalindrom(str,index, i)){
                // add that partation left part substring into list.
               list.add(str.substring(index, i+1));
                
                //And then call rucursion fun for partation right part subString.
               partationFun(str, i+1, ans, list);
                
                //When we return back remove the last insert subString.
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