class Solution {
    
    public boolean checkInclusion(String s1, String s2) {
        
//         ArrayList<String>list = generatePermutation(s1, "", new ArrayList<>());
        
//         for(String s : list){
//             if(s2.contains(s)){
//                 return true;
//             }
//         }
//         return false;
        if(s1.length()>s2.length())return false;
        
        int[]s1Frq = new int[26];
        int[]s2Frq = new int[26];
        
        for(int i = 0;i<s1.length();i++){
            s1Frq[s1.charAt(i) - 'a']++;
            s2Frq[s2.charAt(i) - 'a']++;
        }
        
        for(int i = s1.length();i<s2.length();i++){
            if(isMatch(s1Frq, s2Frq)){return true;}
             s2Frq[s2.charAt(i) - 'a']++;
             s2Frq[s2.charAt(i - s1.length()) - 'a']--;
        }
        return isMatch(s1Frq, s2Frq);
    }
    
   boolean isMatch(int[]arr, int[]arr2){
       for(int i = 0;i<26;i++){
           if(arr[i]!= arr2[i]){return false;}
       }
       return true;
   }  
    
    
    
    
    
    
    
//     Generate all Permutation Of A String..   
//     ArrayList<String> generatePermutation(String str, String Permutation, ArrayList<String> list){
         
//         if(str.length() == 0){
//             list.add(Permutation);
//         }
        
//         for(int i = 0;i<str.length();i++){
//             char currCh = str.charAt(i);
//             String newString = str.substring(0, i) + str.substring(i+1);
//             generatePermutation(newString,Permutation+currCh, list);
//         }
//         return list;
//     }
}