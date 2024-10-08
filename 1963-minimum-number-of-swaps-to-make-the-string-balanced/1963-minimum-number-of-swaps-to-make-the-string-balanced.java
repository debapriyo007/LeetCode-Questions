class Solution {
    public int minSwaps(String s) {
        
        // int cnt = 0;
        // for(char ch : s.toCharArray()){
        //     if(ch == '['){
        //         cnt++;
        //     }else{
        //         if(cnt > 0){
        //             cnt --;
        //         }
        //     }
        // }
        // return (cnt+1)/2;
            
        char[]strArr = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        int cnt = 0;
        int cntOpenBracket = 0;
        while(i<j){
            if (strArr[i] == '[') {
                cntOpenBracket++; 
            } else if (strArr[i] == ']') {
                cntOpenBracket--;  
            }
            
            if(cntOpenBracket < 0){
                while(i<j && strArr[j] != '['){
                    j--;
                }
                swap(strArr, i, j);
                cnt++;
                cntOpenBracket = 1;
                j--;
            }
            i++;
        }
        return cnt;   
    }
    void swap(char[]arr, int x, int y){
        char tem = arr[x];
        arr[x] = arr[y];
        arr[y] = tem;
    }
}