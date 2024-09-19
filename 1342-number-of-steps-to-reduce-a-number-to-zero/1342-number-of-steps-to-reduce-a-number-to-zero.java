class Solution {
    public int numberOfSteps(int num) {
        
        int cnt = 0;
        while(num!= 0){
            if(num%2 == 0){
                cnt++;
                //even.
                num = num/2;
            }else{
                cnt++;
                num = num-1;
            }
        }
       return cnt; 
    }
}