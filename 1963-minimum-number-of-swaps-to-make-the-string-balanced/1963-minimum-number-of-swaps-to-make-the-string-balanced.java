class Solution {
    public int minSwaps(String s) {
        
        int cnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == '['){
                cnt++;
            }else{
                if(cnt > 0){
                    cnt --;
                }
            }
        }
        return (cnt+1)/2;
    }
}