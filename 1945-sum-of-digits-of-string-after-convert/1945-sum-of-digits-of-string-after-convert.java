class Solution {
    public int getLucky(String s, int k) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        char ch = 'a';
        for(int i = 1;i<= 26;i++){
            map.put(ch, i);
            ch++;
        }
        
        String numbeString = "";
        for(char currCh : s.toCharArray()){
             int currCharVal = map.get(currCh);
             String newChar = Integer.toString(currCharVal);
             numbeString += newChar;
        }
        
        //"9999"
        // int num = Integer.parseInt(numbeString); //this line give me error..
        int ans = 0;
        for(int i = 0 ;i<k;i++){
            ans = 0;
            // while(num!=0){
            //     int lastDig = num%10;
            //     ans += lastDig;
            //     num = num/10;
            // }
            // num = ans;
            for(char chh : numbeString.toCharArray()){
                ans+= Character.getNumericValue(chh);
            }
            numbeString = Integer.toString(ans);
        }
        return ans;
    }
}