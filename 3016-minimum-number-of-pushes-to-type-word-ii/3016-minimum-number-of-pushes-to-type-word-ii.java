class Solution {
    public int minimumPushes(String word) {
        
        // track the frequency.
        int[]frqArr = new int[26];
        for(char ch : word.toCharArray()){
            frqArr[ch - 'a'] ++;
        }
        
        Arrays.sort(frqArr);
        // i need element decreasing order.
        int cnt = 0;
        int minKeyPress = 0;
        for(int i = 25;i>=0 ;i--){
            
            int mul = 0;
            if(cnt<8){
                mul = 1;
            }else if(cnt<16){
                mul = 2;
            }else if(cnt<24){
                mul = 3;
            }else{
                mul = 4;
            }
            int val = frqArr[i]*mul;
            minKeyPress+= val;
            cnt++;
        }
        return minKeyPress;
    }
}