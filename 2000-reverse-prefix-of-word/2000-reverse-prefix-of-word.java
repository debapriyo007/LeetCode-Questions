class Solution {
    public String reversePrefix(String word, char ch) {
        
        int fstOcc = -1;
       for(int i = 0;i<word.length();i++){
           if(word.charAt(i) == ch){
              fstOcc = i; 
              break;
           }
       }
       String ans = reverse(0,fstOcc , word);
        return ans;
    }
    
    public String reverse(int si, int ei, String str){
        char[]arr = str.toCharArray();
        while(si < ei){
           char tem = arr[si];
            arr[si] = arr[ei];
            arr[ei] = tem;
            si++;
            ei--;
        }
        return new String(arr);
    }
    
}