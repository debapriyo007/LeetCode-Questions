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
        
        
        for(int i = index;i<str.length();i++){ //why (i = index)..coz base index i wann partation , and partation till the end.
            
            //Suppose , i partation at 0'th index .
            //i will check partion's left part means, (0-0) is palindrom or not ?
            
            if(isPalindrom(str,index, i)){ //if palindrom 
                
               list.add(str.substring(index, i+1)); //i i will take that substring and add to it in list. 
                
               partationFun(str, i+1, ans, list); //recursivly call for the next substring which is left partation right side.
                
              list.remove(list.size()-1); //when the function ruturn back make sure remove the last inserted substring.
            }
           
        }
    }
    

    //check palindrom methord.    
    public static boolean isPalindrom(String str, int si, int ei){
        while(si<=ei){
            if(str.charAt(si++)!=str.charAt(ei--)){
                return false;
            }
        }
        return true;
    }
}




