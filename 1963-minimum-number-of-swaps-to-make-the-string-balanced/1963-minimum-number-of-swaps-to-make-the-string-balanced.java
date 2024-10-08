class Solution {
    public int minSwaps(String s) {
       
        char[]strArr = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        int cnt = 0;
        int cntOpen = 0;
        while(i<j){
            if (strArr[i] == '[') {
                cntOpen++; 
            } else if (strArr[i] == ']') {
                cntOpen--;  
            }
            
            if(cntOpen < 0){
                while(i<j && strArr[j] != '['){
                    j--;
                }
                swap(strArr, i, j);
                cnt++;
                cntOpen = 1;
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